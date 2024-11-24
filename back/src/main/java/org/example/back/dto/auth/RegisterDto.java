package org.example.back.dto.auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.back.entity.role.RoleType;

public record RegisterDto(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        String username,
        @NotEmpty
        String password,
        @NotNull
        RoleType roleType
) {
}
