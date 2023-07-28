package com.IT.environment.service;

import com.IT.environment.dto.TeamDto;
import com.IT.environment.entity.Employee;
import com.IT.environment.entity.Team;
import com.IT.environment.entity.TeamVsEmployees;
import com.IT.environment.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;


    public Object createTeam(TeamDto teamDto) {
        for (int i = 0; i < teamDto.getEmployees().length; i++) {
            Optional<Team> byName = teamRepository.findByName(teamDto.getName());
            if (byName.isEmpty()) {
                if (teamDto.getTeamLead_id() != 0 && teamDto.getName() != null) {
                    teamRepository.addTeamLeaD(teamDto.getName(), teamDto.getTeamLead_id());
                }
                if (teamDto.getEmployees().length>=1) {
                    for (int employee_id : teamDto.getEmployees()) {
                        teamRepository.addTeamVsEmployee(teamDto.getName(), teamDto.getTeamLead_id(), employee_id);
                    }
                }
            }
        }
        return teamDto;
    }
}
