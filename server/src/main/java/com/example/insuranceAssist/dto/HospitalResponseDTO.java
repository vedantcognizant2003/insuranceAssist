package com.example.insuranceAssist.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HospitalResponseDTO {

    private UUID id;
    private String name;
    private String address;
    private Double rating;
    private String clientContactEmail;
    private Long clientContactNumber;
    private int network;

    public HospitalResponseDTO(UUID id, String name, String address, Double rating, String clientContactEmail, Long clientContactNumber, int network) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.clientContactEmail = clientContactEmail;
        this.clientContactNumber = clientContactNumber;
        this.network = network;
    }
}
