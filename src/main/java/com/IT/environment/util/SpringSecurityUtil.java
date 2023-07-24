package com.IT.environment.util;

import com.IT.environment.config.CustomUserDetails;
import com.IT.environment.entity.Email;
import com.IT.environment.entity.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUtil {

    public static Employee getCurrentEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        /* System.out.println(user.getUsername());
        Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) user.getAuthorities();
         Collection<? extends GrantedAuthority> authorities = user.getAuthorities();*/
        return user.getProfile();
    }

    public static Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getProfile().getId();
    }
    public static Email getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getProfile().getEmail();
    }
}
