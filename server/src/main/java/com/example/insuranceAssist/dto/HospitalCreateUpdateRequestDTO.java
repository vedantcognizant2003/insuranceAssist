package com.example.insuranceAssist.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HospitalCreateUpdateRequestDTO {

    private String name;
    private String address;
    private String email;
    private Integer beds;
    private Double rating;
    private String clientContactEmail;
    private Long clientContactNumber;
    private int network;


}
