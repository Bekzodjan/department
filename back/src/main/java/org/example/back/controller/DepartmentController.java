package org.example.back.controller;

import org.example.back.service.department.DepartmentServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }
    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_EMPLOYEE')")
    public HttpEntity<?> getDepartments() {
        return departmentServiceImpl.getDepartments();
    }
}
