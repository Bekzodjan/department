package org.example.back.projection;

import org.example.back.entity.department.Department;
import org.example.back.entity.role.Role;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeePr {
    Integer getId();

    @Value("#{target.user.firstName + ' ' + target.user.lastName}")
    String getFullName();

    @Value("#{target.user.username}")
    String getUsername();
    @Value("#{target.user.password}")
    String getPassword();
    @Value("#{target.user.enabled}")
    Boolean getEnabled();
    @Value("#{target.user.roles}")
    List<Role> getRoles();
    @Value("#{target.user.department}")
    Department getDepartment();
    Boolean getHasUser();
    LocalDateTime getArrivedDate();
    LocalDateTime getGoneDate();
}
