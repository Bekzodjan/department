package org.example.back.dto.employee;

import java.time.LocalDateTime;

public record EmployeeDto(
        Long userId,
        Boolean hasUser,
        LocalDateTime arrivedDate
) {
}
