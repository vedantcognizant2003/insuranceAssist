package com.example.insuranceAssist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "policy_type_master")
@Data
public class PolicyTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16)
    private String tier;

    @Column(name = "premium_base")
    private int premiumBase;

    @Column(name = "premium_per_dependent")
    private int premiumPerDependent;

    private int deductible;

    @Column(name = "insurer_pay_percentage")
    private int insurerPayPercentage;

    @Column(length = 128)
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getPremiumBase() {
        return premiumBase;
    }

    public void setPremiumBase(int premiumBase) {
        this.premiumBase = premiumBase;
    }

    public int getPremiumPerDependent() {
        return premiumPerDependent;
    }

    public void setPremiumPerDependent(int premiumPerDependent) {
        this.premiumPerDependent = premiumPerDependent;
    }

    public int getDeductible() {
        return deductible;
    }

    public void setDeductible(int deductible) {
        this.deductible = deductible;
    }

    public int getInsurerPayPercentage() {
        return insurerPayPercentage;
    }

    public void setInsurerPayPercentage(int insurerPayPercentage) {
        this.insurerPayPercentage = insurerPayPercentage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
