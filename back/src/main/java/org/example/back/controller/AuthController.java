package org.example.back.controller;

import lombok.RequiredArgsConstructor;
import org.example.back.dto.auth.LoginDto;
import org.example.back.dto.auth.RegisterDto;
import org.example.back.service.auth.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
        return authService.registerUser(registerDto);
    }

    @PostMapping("/login")
    public HttpEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        return authService.loginUser(loginDto);
    }

    @GetMapping("/me")
    public HttpEntity<?> me() {
        return authService.me();
    }
}
