package com.IT.environment.entity;

import com.IT.environment.enums.leaveRequest.LeaveRequestType;
import com.IT.environment.enums.leaveRequest.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class LeaveRequest {
    public LeaveRequest(Employee employee, LeaveRequestType requestType, LocalDate fromDate, LocalDate toDate, RequestStatus requestStatus) {
        this.employee = employee;
        RequestType = requestType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.requestStatus = requestStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private LeaveRequestType RequestType;

    private LocalDate fromDate;

    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
}
