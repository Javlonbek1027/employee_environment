package com.IT.environment.entity;

import com.IT.environment.enums.WorkStatus;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "team_vs_employees")
@NoArgsConstructor
public class TeamVsEmployees {
    public TeamVsEmployees(Employee employee, Team team, WorkStatus workStatus) {
        this.employee = employee;
        this.team = team;
        this.workStatus = workStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private WorkStatus workStatus;
}
