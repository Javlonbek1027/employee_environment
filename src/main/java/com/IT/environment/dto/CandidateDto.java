package com.IT.environment.dto;

import com.IT.environment.enums.candidates.ExperienceInSphere;
import com.IT.environment.enums.candidates.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CandidateDto {
    private String FirstName;

    private String LastName;

    private String PositionTitle;

    private String Skills;

    private Float ExperienceInYears;

    private ExperienceInSphere experienceInSphere;

    private Status status;
}
