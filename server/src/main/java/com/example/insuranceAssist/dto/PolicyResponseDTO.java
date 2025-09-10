package com.example.insuranceAssist.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class PolicyResponseDTO {

    private UUID policyId;
    private LocalDate startDate;
    private LocalDate endDate;

}
