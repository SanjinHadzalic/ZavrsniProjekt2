package org.springframework.boot.backend.controller.jwt;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.dto.AuthRequestDTO;
import org.springframework.boot.backend.dto.JwtResponseDTO;
import org.springframework.boot.backend.dto.RefreshTokenRequestDTO;
import org.springframework.boot.backend.dto.RegisterRequestDTO;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.boot.backend.entity.user.RefreshToken;
import org.springframework.boot.backend.service.jwt.JwtService;
import org.springframework.boot.backend.service.jwt.RefreshTokenService;
import org.springframework.boot.backend.service.jwt.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AuthController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    private RefreshTokenService refreshTokenService;
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/api/v1/login")
    public JwtResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            ApplicationUser user = userDetailsService.findApplicationUserByUsername(authRequestDTO.getUsername()); // Fetch user

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequestDTO.getUsername());
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.generateToken(user))
                    .token(refreshToken.getToken())
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

    @PostMapping("/api/v1/refreshToken")
    public JwtResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO){
        log.info("Inside refreshToken method");
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserInfo)
                .map(userInfo -> {
                    ApplicationUser user = userDetailsService.findApplicationUserByUsername(userInfo.getUsername());
                    String accessToken = jwtService.generateToken(user);
                    return JwtResponseDTO.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequestDTO.getToken()).build();
                }).orElseThrow(() ->new RuntimeException("Refresh Token is not in DB..!!"));
    }

    @PostMapping("/api/v1/register")
    public ResponseEntity<RegisterRequestDTO> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        userDetailsService.registerNewUser(registerRequestDTO);
        return ResponseEntity.ofNullable(registerRequestDTO);
    }

    @PostMapping("/api/v1/logout")
    public void logout() {
        log.info("Logout...");
    }
}
