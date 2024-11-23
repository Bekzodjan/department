package org.example.back.controller;

import org.example.back.service.employee.EmployeeServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {
    private final EmployeeServiceImpl userServiceImpl;

    public EmployeeController(EmployeeServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public HttpEntity<?> getEmployees() {
        return userServiceImpl.getAllEmployee();
    }
    @PutMapping("/{id}/gone")
    public HttpEntity<?> updateGoneDate(@PathVariable Long id) {
        return userServiceImpl.putGoneDate(id);
    }
}
