package org.example.back.service.employee;

import org.example.back.dto.employee.EmployeeDto;
import org.example.back.entity.employee.Employee;
import org.example.back.entity.user.User;
import org.example.back.projection.EmployeePr;
import org.example.back.repository.EmployeeRepo;
import org.example.back.repository.UserRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final UserRepo userRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, UserRepo userRepo) {
        this.employeeRepo = employeeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public HttpEntity<?> getAllEmployee() {
        List<EmployeePr> all = employeeRepo.findAllBy();
        return new HttpEntity<>(all);
    }

    @Override
    public HttpEntity<?> getEmployeeByDepartmentId(Long id) {
        return null;
    }

    @Override
    public HttpEntity<?> putGoneDate(Long id) {
        Employee user = employeeRepo.findById(id).orElseThrow();
        user.setGoneDate(LocalDateTime.now());
        Employee save = employeeRepo.save(user);
        return new HttpEntity<>(save);
    }

    @Override
    public HttpEntity<?> addEmployee(EmployeeDto employee) {
        User user = userRepo.findById(employee.userId()).orElseThrow();
        Employee save = employeeRepo.save(Employee.builder().user(user).hasUser(employee.hasUser()).arrivedDate(employee.arrivedDate()).build());
        return ResponseEntity.ok(save);
    }
}
