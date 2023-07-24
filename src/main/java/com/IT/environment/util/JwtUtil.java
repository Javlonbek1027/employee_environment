package com.IT.environment.util;

import com.IT.environment.dto.email_JWT.JwtDTO;
import com.IT.environment.exceptions.AppForbiddenException;
import com.IT.environment.exceptions.TokenNotValidException;
import com.IT.environment.enums.employee.EmployeeRole;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public class JwtUtil {
    private static final int tokenLiveTime = 1000 * 3600 * 24; // 1-day
    private static final String secretKey = "mazgi";

    public static String encode(String email, EmployeeRole role) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("email", email);
        jwtBuilder.claim("role", role);

        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLiveTime)));
        jwtBuilder.setIssuer("youtube test portal");
        return jwtBuilder.compact();
    }

    public static String decodeForEmailVerification(String token) {
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);

        Jws<Claims> jws = jwtParser.parseClaimsJws(token);

        Claims claims = jws.getBody();

        String email = (String) claims.get("email");
        return email;
    }
    public static JwtDTO decode(String token) {
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);

        Jws<Claims> jws = jwtParser.parseClaimsJws(token);

        Claims claims = jws.getBody();

        String username = (String) claims.get("email");

        String role = (String) claims.get("role");
        EmployeeRole profileRole = EmployeeRole.valueOf(role);

        return new JwtDTO(username, profileRole);
    }
    public static String encode(String email) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("email", email);
        int tokenLiveTime = 1000 * 3600 * 1;
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLiveTime)));
        jwtBuilder.setIssuer("Mazgi");

        return jwtBuilder.compact();
    }

    public static String getIdFromHeader(HttpServletRequest request) {
        try {
            return (String) request.getAttribute("email");
        } catch (RuntimeException e) {
            throw new TokenNotValidException("Not Authorized");
        }
    }
    public static String getIdFromHeader(HttpServletRequest request,EmployeeRole role){
        String id= (String) request.getAttribute("email");
        EmployeeRole jwtRole= (EmployeeRole) request.getAttribute("role");

        if (!role.equals(jwtRole)) {
            throw new AppForbiddenException("method not allowed");
        }
        return id;
    }
}
