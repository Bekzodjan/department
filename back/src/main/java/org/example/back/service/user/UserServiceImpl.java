package org.example.back.service.user;

import org.example.back.entity.user.User;
import org.example.back.repository.UserRepo;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public HttpEntity<?> putGoneDate(Long id) {
        User user = userRepo.findById(id).orElseThrow();
        user.setGoneDate(LocalDateTime.now());
        User save = userRepo.save(user);
        return new HttpEntity<>(save);
    }
}
