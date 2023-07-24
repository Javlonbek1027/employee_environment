package com.IT.environment.dto.employee;

import com.IT.environment.dto.email_JWT.EmailDto;
import com.IT.environment.enums.employee.EmployeeRole;
import com.IT.environment.enums.employee.EmploymentMode;
import com.IT.environment.enums.employee.Gender;
import com.IT.environment.enums.employee.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {

    private String firstName;

    private String lastname;

    private LocalDate dateOfBirth;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String phoneNumber;

    private EmailDto email;

    private EmploymentMode employmentMode;

    private LocalDate hireDate;

    private LocalDate resignationDate;

    private LocalDate probationPeriod;

    private EmployeeRole role;

    private Float salary;

    private Integer reportingManager;
}
