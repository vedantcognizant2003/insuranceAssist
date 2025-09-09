package com.example.insuranceAssist.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DependentDetailsResponseDTO {

    private UUID clientId;
    private List<DependentDetailsDTO> dependentDetails;

    public DependentDetailsResponseDTO(UUID clientId, List<DependentDetailsDTO> dependentDetails) {
        this.clientId = clientId;
        this.dependentDetails = dependentDetails;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<DependentDetailsDTO> getDependentDetails() {
        return dependentDetails;
    }

    public void setDependentDetails(List<DependentDetailsDTO> dependentDetails) {
        this.dependentDetails = dependentDetails;
    }
}
