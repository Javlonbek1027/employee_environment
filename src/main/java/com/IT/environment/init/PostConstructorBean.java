package com.IT.environment.init;

import com.IT.environment.entity.Email;
import com.IT.environment.entity.Employee;
import com.IT.environment.enums.employee.EmployeeRole;
import com.IT.environment.enums.employee.EmploymentMode;
import com.IT.environment.enums.employee.Gender;
import com.IT.environment.enums.employee.MaritalStatus;
import com.IT.environment.repository.EmailRepo;
import com.IT.environment.repository.EmployeeRepository;
import com.IT.environment.util.MD5Util;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostConstructorBean {
    private final EmployeeRepository employeeRepo;
    private final EmailRepo emailRepo;

    @PostConstruct
    public void init(){
        Optional<Employee> optional = employeeRepo.findAllByRole(EmployeeRole.ROLE_ADMIN);
        if(!optional.isEmpty()){
            System.out.println("admin already created");
        return;
        }

        Employee entity = new Employee();
        Email email = new Email();
        entity.setFirstName("Javlonbek");
        entity.setLastname("Shobotayev");
        email.setEmailName("shoboteyev@gmail.com");
        email.setPassword(MD5Util.encode("1234567"));
        emailRepo.save(email);
        emailRepo.findByEmailName(email.getEmailName());
        entity.setEmail_id(emailRepo.findByEmailName(email.getEmailName()).getId());
        entity.setRole(EmployeeRole.ROLE_ADMIN);
        entity.setDateOfBirth(LocalDate.parse("2003-10-27"));
        entity.setGender(Gender.MALE);
        entity.setEmploymentMode(EmploymentMode.FULL_TIME);
        entity.setHireDate(LocalDate.now());
        entity.setMaritalStatus(MaritalStatus.UNMARRIED);
        entity.setPhoneNumber("+998977753388");
        entity.setResignationDate(LocalDate.now());
        employeeRepo.save(entity);
        System.out.println("Admin added");
    }
}