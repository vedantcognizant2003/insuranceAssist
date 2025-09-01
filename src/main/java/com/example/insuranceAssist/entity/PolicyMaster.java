package com.example.insuranceAssist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "policy_master")
@Data
public class PolicyMaster {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "policy_id")
    private UUID policyId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientMaster client;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(precision = 12, nullable = false)
    private BigDecimal premium;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PolicyNetworkTable> networkEntries;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Authorization> authorizations;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
