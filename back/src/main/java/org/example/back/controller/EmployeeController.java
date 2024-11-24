package org.example.back.controller;

import org.example.back.dto.employee.EmployeeDto;
import org.example.back.entity.employee.Employee;
import org.example.back.entity.user.User;
import org.example.back.repository.EmployeeRepo;
import org.example.back.repository.UserRepo;
import org.example.back.service.employee.EmployeeServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public HttpEntity<?> addEmployee(@RequestBody EmployeeDto employee) {
        return userServiceImpl.addEmployee(employee);
    }
}
