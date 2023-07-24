package com.IT.environment.controller;

import com.IT.environment.dto.leaveRequests.LeaveRequestCreateDto;
import com.IT.environment.dto.leaveRequests.LeaveRequestDto;
import com.IT.environment.service.LeaveRequestService;
import com.IT.environment.util.SpringSecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leave")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @PreAuthorize("hasRole('ADMIN')") // admin kimnidir o'rniga to'ldiradi
    @PostMapping("/create/{id}")
    private ResponseEntity<?> createResponse(@PathVariable Integer id, @RequestBody LeaveRequestCreateDto dto){
        LeaveRequestCreateDto leaveRequestDto = leaveRequestService.createRequest(id,dto);
        return ResponseEntity.ok(leaveRequestDto);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')") // admin va moderatorlar o'zi ucun to'ldiradi
    @PostMapping("/create/own")
    private ResponseEntity<?> createResponse( @RequestBody LeaveRequestCreateDto dto){
        LeaveRequestCreateDto leaveRequestDto = leaveRequestService.createRequest(SpringSecurityUtil.getCurrentUserId(),dto);
        return ResponseEntity.ok(leaveRequestDto);
    }


    @GetMapping("/my/requests")
    private ResponseEntity<?> myRequests(){
        List<LeaveRequestDto> dtoList = leaveRequestService.getMyRequests(SpringSecurityUtil.getCurrentUserId());
        return ResponseEntity.ok(dtoList);
    }

}

