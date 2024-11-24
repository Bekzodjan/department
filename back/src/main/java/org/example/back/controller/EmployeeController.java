package org.example.back.controller;

import org.example.back.dto.employee.EmployeeDto;
import org.example.back.entity.employee.Employee;
import org.example.back.service.employee.EmployeeServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {
    private final EmployeeServiceImpl userServiceImpl;

    public EmployeeController(EmployeeServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    public HttpEntity<?> getEmployees() {
        return userServiceImpl.getAllEmployee();
    }

    @PutMapping("/{id}/gone")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    public HttpEntity<?> updateGoneDate(@PathVariable Long id) {
        return userServiceImpl.putGoneDate(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    public HttpEntity<?> addEmployee(@RequestBody EmployeeDto employee) {
        return userServiceImpl.addEmployee(employee);
    }
}
