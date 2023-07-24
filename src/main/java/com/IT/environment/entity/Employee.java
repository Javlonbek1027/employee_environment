package com.IT.environment.entity;

import com.IT.environment.enums.employee.EmployeeRole;
import com.IT.environment.enums.employee.EmploymentMode;
import com.IT.environment.enums.employee.Gender;
import com.IT.environment.enums.employee.MaritalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    public Employee(String firstName, String lastname, LocalDate dateOfBirth, Gender gender, MaritalStatus maritalStatus, String phoneNumber, EmploymentMode employmentMode, LocalDate hireDate, LocalDate resignationDate, LocalDate probationPeriod, EmployeeRole role, Float salary, Integer reportingManager) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.phoneNumber = phoneNumber;
        this.employmentMode = employmentMode;
        this.hireDate = hireDate;
        this.resignationDate = resignationDate;
        this.probationPeriod = probationPeriod;
        this.role = role;
        this.salary = salary;
        this.reportingManager = reportingManager;
    }

    /*
    First name
    Last name
    Date of birth
    Gender
    Marital Status
    Phone number
    Email id
    Employment Mode(Full time, part time)
    Hire Date
    Resignation Date
    Probation Period
    Role
    Salary
    Reporting manager
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;

    private String lastname;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private String phoneNumber;

    @Column(name="email_id")
    private String email_id;
    @OneToOne
    @JoinColumn(name = "email_id", insertable=false, updatable=false)
    private Email email;

    @Enumerated(EnumType.STRING)
    private EmploymentMode employmentMode;

    private LocalDate hireDate;

    private LocalDate resignationDate;

    private LocalDate probationPeriod;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    private Float salary;

    private Integer reportingManager;

}
