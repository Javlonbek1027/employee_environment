package com.IT.environment.controller;

import com.IT.environment.dto.CandidateDto;
import com.IT.environment.service.RecruitmentService;
import com.IT.environment.util.SpringSecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentController {
    private final RecruitmentService recruitmentService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/info/{id}") // ma'lum id dagi candidate ma'lumotlari
    public ResponseEntity<?> getCandidate(@PathVariable Integer id){
        CandidateDto candidateDto = recruitmentService.getInfo(id);
        return ResponseEntity.ok(candidateDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MDERATOR')")
    @GetMapping("/info/{id}/comment") // ma'lum id dagi candidate ga yozilgan commentlar
    public ResponseEntity<?> getComment(@PathVariable Integer id){
        List<String> text = recruitmentService.readComment(id);
        return ResponseEntity.ok(text);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MDERATOR')")
    @PostMapping("/info/{id}/comment/whrite")// ayni saytda turgan odam ma'lum id li candidate ga komment qoldiriwi
    public ResponseEntity<?> writeComment(@PathVariable Integer id, @RequestBody String comment){
        String text = recruitmentService.writeComment(id,comment, SpringSecurityUtil.getCurrentUserId());
        return ResponseEntity.ok(text);
    }
}
