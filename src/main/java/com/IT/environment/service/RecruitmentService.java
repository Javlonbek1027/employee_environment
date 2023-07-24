package com.IT.environment.service;

import com.IT.environment.dto.CandidateDto;
import com.IT.environment.entity.Candidate;
import com.IT.environment.entity.Comment;
import com.IT.environment.entity.Employee;
import com.IT.environment.repository.CandidateRepo;
import com.IT.environment.repository.CommentRepo;
import com.IT.environment.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruitmentService {
    private final CandidateRepo candidateRepo;

    private final EmployeeRepository employeeRepository;

    private final CommentRepo commentRepo;

    public CandidateDto getInfo(Integer id) {
        Optional<Candidate> byId = candidateRepo.findById(id);
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setFirstName(byId.get().getFirstName());
        candidateDto.setExperienceInSphere(byId.get().getExperienceInSphere());
        candidateDto.setExperienceInYears(byId.get().getExperienceInYears());
        candidateDto.setLastName(byId.get().getLastName());
        candidateDto.setSkills(byId.get().getSkills());
        candidateDto.setPositionTitle(byId.get().getPositionTitle());
        return candidateDto;
    }

    public String writeComment(Integer id, String comment, Integer employeeId) {
        Comment comment1 = new Comment();
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Candidate> candidate = candidateRepo.findById(id);
        comment1.setComment(comment);
        comment1.setCandidate(candidate.get());
        comment1.setEmployee(employee.get());
        commentRepo.save(comment1);
        return comment;
    }

    public List<String> readComment(Integer id) {
        List<Comment> allByEmployee_id = commentRepo.findAllByEmployee_Id(id);
        List<String> comments = new ArrayList<>();
        for (Comment comment : allByEmployee_id) {
            comments.add(comment.getComment());
        }
        return comments;
    }
}
