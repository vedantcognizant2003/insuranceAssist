package com.example.insuranceAssist.dto;

import lombok.Data;

@Data
public class HospitalDetailsResponseDTO {

    private String name;
    private String address;
    private String email;
    private Double rating;
    private String clientContactEmail;
    private Long clientContactNumber;
    private int network;

    public HospitalDetailsResponseDTO(String name, String address, String email, Double rating, String clientContactEmail, Long clientContactNumber, int network) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.rating = rating;
        this.clientContactEmail = clientContactEmail;
        this.clientContactNumber = clientContactNumber;
        this.network = network;
    }
}
