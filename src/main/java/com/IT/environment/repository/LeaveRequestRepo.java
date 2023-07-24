package com.IT.environment.repository;

import com.IT.environment.entity.Employee;
import com.IT.environment.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest,Long> {

    List<LeaveRequest> findAllByEmployee_Id(Integer id);
}
