package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "hospital_master")
@Data
public class HospitalMaster {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 160)
    private String name;

    @Column(length = 400)
    private String address;

    @Column(length = 120, unique = true)
    private String email;

    private Integer beds;

    @Column(precision = 3)
    private Double rating;

    @Column(length = 120)
    private String clientContactEmail;

    private Long clientContactNumber;

    private int network;

}
