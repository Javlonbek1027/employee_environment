package com.IT.environment.controller;

import com.IT.environment.dto.TeamDto;
import com.IT.environment.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/add")
    public ResponseEntity<?> createTeam(@RequestBody TeamDto teamDto){
        return ResponseEntity.ok(teamService.createTeam(teamDto));
    }
}
