package org.example.back.service.department;

import org.example.back.entity.department.Department;
import org.example.back.repository.DepartmentRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public HttpEntity<?> getDepartments() {
        List<Department> all = departmentRepo.findAll();
        return ResponseEntity.ok(all);
    }
}
