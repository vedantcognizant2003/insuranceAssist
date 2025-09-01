package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "authorization")
@Data
public class Authorization {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private PolicyMaster policy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "claim_type_id", nullable = false)
    private ClaimTypeMaster claimType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private AgentMaster agent;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private StatusTypeMaster status;

    @Column(name = "open_date", nullable = false)
    private LocalDateTime openDate;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;

    @Column(name = "procedure_notes", length = 400)
    private String procedureNotes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
