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

    public DependentProfileViewDTO(UUID id, String name, String gender, String relationName, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.relationName = relationName;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
