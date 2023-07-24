package com.IT.environment.config;

import com.IT.environment.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Employee employeee;

    public CustomUserDetails(Employee employeee) {
        this.employeee = employeee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("get Role");

        List<GrantedAuthority> list = new LinkedList<>();
        list.add(new SimpleGrantedAuthority(employeee.getRole().name()));

        return list;
    }

    @Override
    public String getPassword() {
        System.out.println("get Password");
        return employeee.getEmail().getPassword();
    }

    @Override
    public String getUsername() {
        return employeee.getEmail().getEmailName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        System.out.println("get  isEnabled");

        // status
        return true;
    }

    public Employee getProfile() {
        return employeee;
    }
}
