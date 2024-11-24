package org.example.back.service.employee;

import org.springframework.http.HttpEntity;

public interface EmployeeService {
    HttpEntity<?> putGoneDate(Long id);
    HttpEntity<?> getAllEmployee();
    HttpEntity<?> getEmployeeByDepartmentId(Long id);
}
