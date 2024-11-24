package org.example.back.service.employee;

import org.example.back.dto.employee.EmployeeDto;
import org.springframework.http.HttpEntity;

public interface EmployeeService {
    HttpEntity<?> putGoneDate(Long id);
    HttpEntity<?> getAllEmployee();
    HttpEntity<?> getEmployeeByDepartmentId(Long id);

    HttpEntity<?> addEmployee(EmployeeDto employee);
}
