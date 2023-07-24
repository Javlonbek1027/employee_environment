package com.IT.environment.dto.login;

import com.IT.environment.enums.employee.EmployeeRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDto {

    private String firstName;

    private String lastName;

    private EmployeeRole employeeRole;

    private String token;
}
