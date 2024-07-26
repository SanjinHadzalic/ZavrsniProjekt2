package org.springframework.boot.backend.entity.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.backend.entity.user.AppUser;

@Data
public class RingCodeCommand {
    @NotBlank(message = "String code must have a value!")
    private String code;
    @NotNull(message = "AppUser must have a valid id!")
    private AppUser appUser;
}
