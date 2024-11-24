package org.example.back.service.jwt;

import org.example.back.entity.user.User;

public interface JwtService {
    String generateJwtToken(User user);
    String extractJwtToken(String token);
}
