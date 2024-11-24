package org.example.back.repository;

import org.example.back.entity.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
