package org.example.back.service.auth;

import org.example.back.dto.auth.LoginDto;
import org.example.back.dto.auth.RegisterDto;
import org.springframework.http.HttpEntity;

public interface AuthService {
    HttpEntity<?> registerUser(RegisterDto registerDto);

    HttpEntity<?> loginUser(LoginDto loginDto);

    HttpEntity<?> me();
}
