package com.IT.environment.controller;

import com.IT.environment.service.InOutService;
import com.IT.environment.util.SpringSecurityUtil;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/door")
@RequiredArgsConstructor
public class InOutDoorController {

    private final InOutService inOutService;

    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    @PostMapping("/in")
    private ResponseEntity<?> inDoor() {
        return ResponseEntity.ok(inOutService.InDoor(SpringSecurityUtil.getCurrentUserId()));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    @PostMapping("/out")
    private ResponseEntity<?> outDoor() {
        return ResponseEntity.ok(inOutService.OutDoor(SpringSecurityUtil.getCurrentUserId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get/info")
    private ResponseEntity<?> getAllInfo(){
        return ResponseEntity.ok(inOutService.getAllObjects());
    }
}
