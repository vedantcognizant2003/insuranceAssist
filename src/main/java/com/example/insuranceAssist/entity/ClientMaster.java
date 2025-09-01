package com.example.insuranceAssist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client_master")
@Data
public class ClientMaster {

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

    private LocalDate dob;

    @Column(length = 120, unique = true)
    private String email;

    private Long phone;

    @Column(length = 400)
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PolicyMaster> policies;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DependentMaster> dependents;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Authorization> authorizations;

}
