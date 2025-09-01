package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "dependent_master")
@Data
public class DependentMaster {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientMaster client;

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

}
