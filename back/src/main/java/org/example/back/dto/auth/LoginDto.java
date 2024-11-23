package org.example.back.dto.auth;

import jakarta.validation.constraints.NotEmpty;

public record LoginDto(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
