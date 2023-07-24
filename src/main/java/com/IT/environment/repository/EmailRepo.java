package com.IT.environment.repository;

import com.IT.environment.entity.Email;
import com.IT.environment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepo extends JpaRepository<Email,String> {
    Email findByEmailName(String name);
    Email findByEmailNameAndPassword(String emailName,String password);
}
