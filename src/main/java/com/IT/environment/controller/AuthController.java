package com.IT.environment.controller;

import com.IT.environment.dto.login.LoginDto;
import com.IT.environment.dto.login.LoginResponseDto;
import com.IT.environment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto){
        LoginResponseDto authResponseDTO = employeeService.login(dto);
        return ResponseEntity.ok(authResponseDTO);
    }
}
