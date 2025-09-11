package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "authorization_log")
@Data
@RequiredArgsConstructor
public class AuthorizationLog {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private PolicyMaster policy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prev_status")
    private StatusTypeMaster prevStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curr_status")
    private StatusTypeMaster currStatus;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public AuthorizationLog(PolicyMaster policy, StatusTypeMaster prevStatus, StatusTypeMaster currStatus, LocalDateTime timestamp) {
        this.policy = policy;
        this.prevStatus = prevStatus;
        this.currStatus = currStatus;
        this.timestamp = timestamp;
    }
}
