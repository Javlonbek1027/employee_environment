package com.IT.environment.controller;

import com.IT.environment.dto.employee.EmployeeDto;
import com.IT.environment.entity.Employee;
import com.IT.environment.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody EmployeeDto dto){
        Employee employee = employeeService.register(dto);
        return ResponseEntity.ok(employee);
    }
}
