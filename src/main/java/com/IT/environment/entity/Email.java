package com.IT.environment.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "email")
public class Email {

    public Email(String emailName, String password) {
        this.emailName = emailName;
        this.password = password;
    }

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String emailName;

    private String password;

}
