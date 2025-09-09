package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "relation_type_master")
@Data
public class RelationTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "relation_name", nullable = false, unique = true, length = 40)
    private String relationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }
}
