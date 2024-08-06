package org.springframework.boot.backend.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.backend.dto.RegisterRequestDTO;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.boot.backend.entity.user.UserRole;
import org.springframework.boot.backend.repository.jwt.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = this.repository.findByUsername(username).get();

        if(user == null) {
            throw new UsernameNotFoundException("Unknown user " + username);
        }

        List<UserRole> userRoleList = user.getRoles();

        String[] roles = new String[userRoleList.size()];

        for(int i = 0; i < userRoleList.size(); i++) {
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

    public ApplicationUser registerNewUser(RegisterRequestDTO userDto) {
        if (repository.existsByUsernameAndEmail(userDto.getUsername(), userDto.getEmail())){
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

        return repository.save(newUser);
    }
}
