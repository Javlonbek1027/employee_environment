package com.IT.environment.repository;

import com.IT.environment.entity.InOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InOutRepo extends JpaRepository<InOut,Long> {


    Optional<InOut> findTopByEmployee_IdOrderByIdDesc(Integer emp_id);
//    ORDER BY TIMESTAMP DESC
//  LIMIT 1
}
