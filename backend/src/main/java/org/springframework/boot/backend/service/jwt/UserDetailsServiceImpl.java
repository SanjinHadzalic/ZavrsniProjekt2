package org.springframework.boot.backend.service.jwt;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.backend.dto.ApplicationUserDTO;
import org.springframework.boot.backend.dto.RegisterRequestDTO;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.boot.backend.entity.user.UserRole;
import org.springframework.boot.backend.repository.jwt.UserRepository;
import org.springframework.boot.backend.service.EmailService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = this.repository.findByUsername(username).get();

        if (user == null) {
            throw new UsernameNotFoundException("Unknown user " + username);
        }

        List<UserRole> userRoleList = user.getRoles();

        String[] roles = new String[userRoleList.size()];

        for (int i = 0; i < userRoleList.size(); i++) {
            roles[i] = userRoleList.get(i).getName();
        }

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    public ApplicationUser registerNewUser(RegisterRequestDTO userDto) throws MessagingException, IOException {
        if (repository.existsByUsernameOrEmail(userDto.getUsername(), userDto.getEmail())) {
            throw new RuntimeException("User already exists by username or email: " + userDto.getUsername() + " " + userDto.getEmail());
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        ApplicationUser newUser = new ApplicationUser();
        UserRole userRole = new UserRole();
        userRole.setName("USER"); // hardcode on purpose!

        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRoles(List.of(userRole));
        newUser.setUsername(userDto.getUsername());
        newUser.setFirstname(userDto.getFirstname());
        newUser.setLastname(userDto.getLastname());
        newUser.setEmail(userDto.getEmail());

        emailService.sendHtmlEmail(newUser, "Successful registration");

        return repository.save(newUser);
    }

    public ApplicationUser findApplicationUserByUsername(String username) {
        Optional<ApplicationUser> applicationUserOpt = repository.findByUsername(username);

        if (applicationUserOpt.isPresent()) {
            ApplicationUser applicationUserRaw = applicationUserOpt.get();
            ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();

            applicationUserDTO.setUsername(applicationUserRaw.getUsername());
            applicationUserDTO.setFirstname(applicationUserRaw.getFirstname());
            applicationUserDTO.setLastname(applicationUserRaw.getLastname());
            applicationUserDTO.setEmail(applicationUserRaw.getEmail());
            applicationUserDTO.setRoles(applicationUserRaw.getRoles());

            return applicationUserRaw;
        } else {
            throw new RuntimeException("Application User not found by username= " + username);
        }
    }
}
