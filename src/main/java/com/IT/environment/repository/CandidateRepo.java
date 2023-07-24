package com.IT.environment.repository;

import com.IT.environment.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
}
