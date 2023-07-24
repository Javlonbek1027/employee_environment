package com.IT.environment.controller;

import com.IT.environment.dto.employee.EmployeeDto;
import com.IT.environment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/info/{id}")
    private ResponseEntity<?> myInfo (@PathVariable Integer id){
        EmployeeDto employeeDto = employeeService.myInfo(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edite/info/{id}")
    private ResponseEntity<?> editInfo(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
          EmployeeDto employeeDto1 = employeeService.editeInfo(id,employeeDto);
          return ResponseEntity.ok(employeeDto1);
    }
}
