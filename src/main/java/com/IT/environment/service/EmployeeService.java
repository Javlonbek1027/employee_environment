package com.IT.environment.service;

import com.IT.environment.dto.email_JWT.EmailDto;
import com.IT.environment.dto.employee.EmployeeDto;
import com.IT.environment.dto.login.LoginDto;
import com.IT.environment.dto.login.LoginResponseDto;
import com.IT.environment.entity.Email;
import com.IT.environment.entity.Employee;
import com.IT.environment.exceptions.ItemNotFoundException;
import com.IT.environment.repository.EmailRepo;
import com.IT.environment.repository.EmployeeRepository;
import com.IT.environment.util.JwtUtil;
import com.IT.environment.util.MD5Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmailRepo emailRepo;

    public LoginResponseDto login(LoginDto dto) {

        Email email = emailRepo.findByEmailNameAndPassword(dto.getEmail(), MD5Util.encode(dto.getPassword()));
        Employee profile = employeeRepository.findByEmail_id(email.getId());

        if (profile == null) {
            throw new ItemNotFoundException("nimadur nito'");
        }

        return toResponseDTO(profile);
    }

    private LoginResponseDto toResponseDTO(Employee employee) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setFirstName(employee.getFirstName());
        loginResponseDto.setLastName(employee.getLastname());
        loginResponseDto.setEmployeeRole(employee.getRole());
        loginResponseDto.setToken(JwtUtil.encode(employee.getEmail().getEmailName(), employee.getRole()));
        return loginResponseDto;
    }

    public EmployeeDto myInfo(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee1 = employee.get();

        return entityToDto(employee1);
    }

    public EmployeeDto entityToDto(Employee employee) {
        return new EmployeeDto(employee.getFirstName(), employee.getLastname(),
                employee.getDateOfBirth(), employee.getGender(), employee.getMaritalStatus(),
                employee.getPhoneNumber(), new EmailDto(employee.getEmail().getEmailName(), employee.getEmail().getPassword()), employee.getEmploymentMode(),
                employee.getHireDate(), employee.getResignationDate(),
                employee.getProbationPeriod(), employee.getRole(), employee.getSalary(), employee.getReportingManager());
    }

    public Employee DtoToEntity(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getFirstName(), employeeDto.getLastname(),
                employeeDto.getDateOfBirth(), employeeDto.getGender(), employeeDto.getMaritalStatus(),
                employeeDto.getPhoneNumber(), employeeDto.getEmploymentMode(),
                employeeDto.getHireDate(), employeeDto.getResignationDate(),
                employeeDto.getProbationPeriod(), employeeDto.getRole(), employeeDto.getSalary(), employeeDto.getReportingManager());
    }
    public Employee register(EmployeeDto dto) {
        Email email = new Email(dto.getEmail().getEmail(), MD5Util.encode(dto.getEmail().getPassword()));
        Email save = emailRepo.save(email);
        Employee employee = DtoToEntity(dto);
        employee.setEmail(save);
        employee.setEmail_id(save.getId());
        Employee save1 = employeeRepository.save(employee);
        return save1;
    }

    public EmployeeDto editeInfo(Integer id, EmployeeDto employeeDto) {

        int emailCounter = 0;
        int employeeCounter = 0;
        Optional<Employee> employee1 = employeeRepository.findById(id);
        Employee employee = employee1.get();
// --------------------------Email------------------------------
        Email email = employee.getEmail();
        EmailDto emailDto = employeeDto.getEmail();
        if (emailDto.getPassword() != null) {
            email.setPassword(emailDto.getPassword());
            emailCounter++;
        }
        if (emailDto.getEmail() != null) {
            emailCounter++;
            email.setEmailName(emailDto.getEmail());
        }
        if (emailCounter>0){
            emailRepo.save(email);
        }

// --------------------------------------------------------------
        if (employeeDto.getResignationDate() != null) {
            employee.setResignationDate(employeeDto.getResignationDate());
            employeeCounter++;
        }
        if (employeeDto.getPhoneNumber() != null) {
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employeeCounter++;
        }
        if (employeeDto.getMaritalStatus() != null) {
            employee.setMaritalStatus(employeeDto.getMaritalStatus());
            employeeCounter++;
        }
        if (employeeDto.getGender() != null) {
            employee.setGender(employeeDto.getGender());
            employeeCounter++;
        }
        if (employeeDto.getHireDate() != null) {
            employee.setHireDate(employeeDto.getHireDate());
            employeeCounter++;
        }
        if (employeeDto.getLastname() != null) {
            employee.setLastname(employeeDto.getLastname());
            employeeCounter++;
        }
        if (employeeDto.getEmploymentMode() != null) {
            employee.setEmploymentMode(employeeDto.getEmploymentMode());
            employeeCounter++;
        }
        if (employeeDto.getDateOfBirth() != null) {
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
            employeeCounter++;
        }
        if (employeeDto.getFirstName() != null) {
            employee.setFirstName(employeeDto.getFirstName());
            employeeCounter++;
        }
        if (employeeDto.getReportingManager() != null) {
            employee.setReportingManager(employeeDto.getReportingManager());
            employeeCounter++;
        }
        if (employeeDto.getSalary() != null) {
            employee.setSalary(employeeDto.getSalary());
            employeeCounter++;
        }
        if (employeeCounter>0){
            employeeRepository.save(employee);
        }
        return employeeDto;
    }
}

