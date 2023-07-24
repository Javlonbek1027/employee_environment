package com.IT.environment.repository;


import com.IT.environment.entity.Employee;
import com.IT.environment.enums.employee.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail_EmailName(String email);

    Employee findByEmail_id(String email);
    Optional<Employee> findAllByRole(EmployeeRole role);



//    @Transactional
//    @Modifying
//    @Query("UPDATE ProfileEntity as p set p.password=?1 where p.email=?2")
//    int updateProfilePassword(String password, String email);
}