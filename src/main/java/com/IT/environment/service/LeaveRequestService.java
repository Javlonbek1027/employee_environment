package com.IT.environment.service;

import com.IT.environment.dto.leaveRequests.LeaveRequestCreateDto;
import com.IT.environment.dto.leaveRequests.LeaveRequestDto;
import com.IT.environment.entity.Employee;
import com.IT.environment.entity.LeaveRequest;
import com.IT.environment.repository.EmployeeRepository;
import com.IT.environment.repository.LeaveRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepo;
    private final EmployeeRepository employeeRepository;
    public LeaveRequestCreateDto createRequest(Integer id, LeaveRequestCreateDto dto) {
        Optional<Employee> byId = employeeRepository.findById(id);

        LeaveRequest leaveRequest = new LeaveRequest(byId.get(),dto.getRequestType(),dto.getFromDate(),dto.getToDate(),dto.getRequestStatus());

        leaveRequestRepo.save(leaveRequest);
        return dto;
    }

    public List<LeaveRequestDto> getMyRequests(Integer currentUserId) {
        List<LeaveRequest> leaveRequests = leaveRequestRepo.findAllByEmployee_Id(currentUserId);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        for (int i = 0; i < leaveRequests.size(); i++){
            leaveRequestDtos.add(entityToDto(leaveRequests.get(i)));
        }
        return leaveRequestDtos;
    }

    private LeaveRequestDto entityToDto(LeaveRequest leaveRequest){
        LeaveRequestDto dto = new LeaveRequestDto(leaveRequest.getEmployee().getId(),
                leaveRequest.getRequestType(),leaveRequest.getFromDate(),
                leaveRequest.getToDate(),leaveRequest.getRequestStatus());
        return dto;
    }
}
