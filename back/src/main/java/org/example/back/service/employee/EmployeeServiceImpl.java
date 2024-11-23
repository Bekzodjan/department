package org.example.back.service.employee;

import org.example.back.entity.timeTable.Employee;
import org.example.back.entity.user.User;
import org.example.back.projection.EmployeePr;
import org.example.back.repository.EmployeeRepo;
import org.example.back.repository.UserRepo;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public HttpEntity<?> getAllEmployee() {
        List<EmployeePr> all = employeeRepo.findAllBy();
        return new HttpEntity<>(all);
    }

    @Override
    public HttpEntity<?> putGoneDate(Long id) {
        Employee user = employeeRepo.findById(id).orElseThrow();
        user.setGoneDate(LocalDateTime.now());
        Employee save = employeeRepo.save(user);
        return new HttpEntity<>(save);
    }
}
