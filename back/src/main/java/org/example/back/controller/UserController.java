package org.example.back.controller;

import org.example.back.service.user.UserServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PutMapping("/{id}/gone")
    public HttpEntity<?> updateGoneDate(@PathVariable Long id) {
        return userServiceImpl.putGoneDate(id);
    }
}
