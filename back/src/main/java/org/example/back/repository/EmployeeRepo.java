package org.example.back.repository;

import org.example.back.entity.department.Department;
import org.example.back.entity.employee.Employee;
import org.example.back.projection.EmployeePr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<EmployeePr> findAllByUserDepartment(Department department);
    List<EmployeePr> findAllBy();
}
