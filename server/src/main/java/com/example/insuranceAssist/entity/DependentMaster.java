package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "dependent_master")
@Data
@RequiredArgsConstructor
public class DependentMaster {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private UserMaster client;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 1)
    private String gender;

    private LocalDate dob;

    private Long phone;

    @Column(length = 120)
    private String email;

    @Column(length = 400)
    private String address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "relation_type_id", nullable = false)
    private RelationTypeMaster relationType;

    @Column(name = "last_updated", nullable = false)
    private LocalDate lastUpdated;

    public DependentMaster(
            String name,
            LocalDate dob,
            Long phone,
            String address,
            RelationTypeMaster relation,
            String gender,
            String email,
            UserMaster client,
            LocalDate lastUpdated
    ){
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.relationType = relation;
        this.gender = gender;
        this.email = email;
        this.client = client;
        this.lastUpdated = lastUpdated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserMaster getClient() {
        return client;
    }

    public void setClient(UserMaster client) {
        this.client = client;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RelationTypeMaster getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationTypeMaster relationType) {
        this.relationType = relationType;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
