package org.springframework.boot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.backend.entity.user.UserRole;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUserDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
//    private String password;
    private List<UserRole> roles = new ArrayList<>();

}
