package com.IT.environment.dto.login;

import com.IT.environment.enums.employee.EmployeeRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDto {

    private EmployeeRole role;
    @Size(min = 3, max = 50)
    private String email;

    @Size(min = 3, max = 50)
    private String password;


}
