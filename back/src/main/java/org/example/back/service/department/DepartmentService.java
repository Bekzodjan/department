package org.example.back.service.department;

import org.springframework.http.HttpEntity;

public interface DepartmentService {
    HttpEntity<?> getDepartments();
}
