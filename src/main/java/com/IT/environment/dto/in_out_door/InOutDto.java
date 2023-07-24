package com.IT.environment.dto.in_out_door;

import com.IT.environment.dto.employee.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InOutDto {
    private EmployeeDto employee;

    private LocalDateTime inTime;

    private LocalDateTime outTime;
}
