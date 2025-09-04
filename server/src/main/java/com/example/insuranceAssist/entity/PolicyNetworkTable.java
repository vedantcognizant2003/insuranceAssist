package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "policy_network_table")
@Data
public class PolicyNetworkTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private PolicyMaster policy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private HospitalMaster hospital;

}
