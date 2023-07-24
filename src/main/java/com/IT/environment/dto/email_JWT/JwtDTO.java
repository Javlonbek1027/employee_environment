package com.IT.environment.dto.email_JWT;

import com.IT.environment.enums.employee.EmployeeRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtDTO {
    private String email;
    private EmployeeRole role;
}
