package com.IT.environment.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_lead_id")
    private Employee teamLead;

}
