package com.IT.environment.repository;

import com.IT.environment.entity.Team;
import com.IT.environment.entity.TeamVsEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamVsEmployees,Integer> {
    @Query(value = "insert into team (name,team_lead_id) VALUES (?1,?2);",nativeQuery = true)
    void addTeamLeaD(String name, int teamLeadId);

    @Query(value = "select * from team where name = ?1",nativeQuery = true)
    Optional<Team> findByName(String name);

    @Query(value = "insert into team_vs_employees(name,team_lead,emloyee_id)",nativeQuery = true)
    void addTeamVsEmployee(String name, int teamLeadId, int employeeId);
}