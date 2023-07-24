package com.IT.environment.config;

import com.IT.environment.entity.Employee;
import com.IT.environment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee optional = employeeRepo.findByEmail_EmailName(email);
        if (optional == null) {
            throw new UsernameNotFoundException("Bad Cretetional");
        }

        return new CustomUserDetails(optional);
    }
}
