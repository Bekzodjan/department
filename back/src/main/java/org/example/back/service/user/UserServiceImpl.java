package org.example.back.service.user;

import org.example.back.entity.user.User;
import org.example.back.repository.UserRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public HttpEntity<?> getUsers() {
        List<User> all = userRepo.findAll();
        return ResponseEntity.ok(all);
    }
}
