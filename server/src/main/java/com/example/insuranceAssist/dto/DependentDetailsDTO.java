package com.example.insuranceAssist.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DependentDetailsDTO {

    private UUID id;
    private String name;
    private LocalDate dob;
    private String relation;
    private String gender;
    private String address;
    private String email;
    private Long phone;

    public DependentDetailsDTO(UUID id, String name, LocalDate dob, String relation, String gender, String address, String email, Long phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.relation = relation;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
