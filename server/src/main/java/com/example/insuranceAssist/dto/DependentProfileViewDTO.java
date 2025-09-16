package com.example.insuranceAssist.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DependentProfileViewDTO {

    private UUID id;
    private String name;
    private String gender;
    private String relationName;
    private LocalDate dob;
    private Long phone;
    private String email;
    private String address;

    public DependentProfileViewDTO(UUID id, String name, String gender, String relationName, LocalDate dob, Long phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.relationName = relationName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
