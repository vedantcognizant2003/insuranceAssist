package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "agent_master")
@Data
public class AgentMaster {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 80, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 1)
    private String gender;

    @Column(length = 120, unique = true)
    private String email;

    @Column
    private Long phone;

    @Column(length = 400)
    private String address;

}
