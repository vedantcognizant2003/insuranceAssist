package com.example.insuranceAssist.service;

import com.example.insuranceAssist.repository.PolicyMasterRepository;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    private final PolicyMasterRepository policyMasterRepository;

    public PolicyService(PolicyMasterRepository policyMasterRepository){
        this.policyMasterRepository = policyMasterRepository;
    }



}
