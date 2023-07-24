package com.IT.environment.entity;

import com.IT.environment.enums.candidates.ExperienceInSphere;
import com.IT.environment.enums.candidates.Status;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class    Candidate {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String FirstName;

    private String LastName;

    private String PositionTitle;

    private String Skills;

    private Float ExperienceInYears;

    @Enumerated(EnumType.STRING)
    private ExperienceInSphere experienceInSphere;

    @Enumerated(EnumType.STRING)
    private Status status;

}
