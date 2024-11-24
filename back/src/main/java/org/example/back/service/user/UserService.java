package org.example.back.service.user;

import org.springframework.http.HttpEntity;

public interface UserService {
    HttpEntity<?> getUsers();
}
