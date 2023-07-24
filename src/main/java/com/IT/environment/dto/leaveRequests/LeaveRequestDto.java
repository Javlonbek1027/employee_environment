package com.IT.environment.dto.leaveRequests;

import com.IT.environment.enums.leaveRequest.LeaveRequestType;
import com.IT.environment.enums.leaveRequest.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestDto {

    private Integer employee_id;

    private LeaveRequestType RequestType;

    private LocalDate fromDate;

    private LocalDate toDate;

    private RequestStatus requestStatus;

}
