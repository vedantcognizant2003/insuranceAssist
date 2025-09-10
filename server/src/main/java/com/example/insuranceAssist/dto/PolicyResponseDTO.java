package com.example.insuranceAssist.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class PolicyResponseDTO {

    private UUID policyId;
    private String tier;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long premium;

    public PolicyResponseDTO(UUID policyId, String tier, LocalDate startDate, LocalDate endDate, Long premium) {
        this.policyId = policyId;
        this.tier = tier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
    }
}
