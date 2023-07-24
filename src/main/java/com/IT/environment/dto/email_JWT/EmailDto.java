package com.IT.environment.dto.email_JWT;

import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String email;
    private String password;
}
