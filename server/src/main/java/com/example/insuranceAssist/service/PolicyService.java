package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.PolicyCreateRequestDTO;
import com.example.insuranceAssist.dto.PolicyResponseDTO;
import com.example.insuranceAssist.entity.Authorization;
import com.example.insuranceAssist.entity.PolicyMaster;
import com.example.insuranceAssist.entity.PolicyTypeMaster;
import com.example.insuranceAssist.entity.UserMaster;
import com.example.insuranceAssist.repository.PolicyMasterRepository;
import com.example.insuranceAssist.repository.PolicyTypeMasterRepository;
import com.example.insuranceAssist.repository.UserMasterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class PolicyService {

    private final PolicyMasterRepository policyMasterRepository;
    private final UserMasterRepository userMasterRepository;
    private final PolicyTypeMasterRepository policyTypeMasterRepository;

    public PolicyService(
            PolicyMasterRepository policyMasterRepository,
            UserMasterRepository userMasterRepository,
            PolicyTypeMasterRepository policyTypeMasterRepository){
        this.policyMasterRepository = policyMasterRepository;
        this.userMasterRepository = userMasterRepository;
        this.policyTypeMasterRepository = policyTypeMasterRepository;
    }


    public PolicyResponseDTO getPolicy(UUID policyId) {

        PolicyMaster policy = policyMasterRepository.findById(policyId)
                .orElseThrow();

        PolicyTypeMaster policyType = policy.getPolicyType();

        return new PolicyResponseDTO(
                policy.getPolicyId(),
                policyType.getTier(),
                policy.getStartDate(),
                policy.getEndDate(),
                policy.getPremium()
        );

    }

    public UUID createPolicy(PolicyCreateRequestDTO request) {

        PolicyTypeMaster policyType = policyTypeMasterRepository.findById(request.getPolicyType())
                .orElseThrow();

        UserMaster client = userMasterRepository.findById(request.getClientId())
                .orElseThrow();

        Long prem = (long) (policyType.getPremiumBase() + ((long) request.getNoOfDependents() * policyType.getPremiumPerDependent()));

        PolicyMaster policy = new PolicyMaster(
                client,
                request.getNoOfDependents(),
                request.getStartDate(),
                request.getEndDate(),
                prem,
                new ArrayList<Authorization>(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                policyType
        );

        PolicyMaster savedPolicy = policyMasterRepository.save(policy);
        return savedPolicy.getPolicyId();

    }

    public PolicyResponseDTO updatePolicy(UUID policyId, PolicyCreateRequestDTO request) {

        PolicyMaster policy = policyMasterRepository.findById(policyId)
                .orElseThrow();

        PolicyTypeMaster policyType = policyTypeMasterRepository.findById(request.getPolicyType())
                .orElseThrow();

        Long updatedPremium = (long) (policyType.getPremiumBase() + ((long) request.getNoOfDependents() * policyType.getPremiumPerDependent()));

        policy.setPolicyType(policyType);
        policy.setUpdatedAt(LocalDateTime.now());
        policy.setDependents(request.getNoOfDependents());
        policy.setPremium(updatedPremium);
        policy.setEndDate(request.getEndDate());

        policyMasterRepository.save(policy);
        return new PolicyResponseDTO(
                policyId,
                policy.getPolicyType().getTier(),
                policy.getStartDate(),
                policy.getEndDate(),
                policy.getPremium()
        );

    }

    public void deletePolicy(UUID policyId) {

        policyMasterRepository.deleteById(policyId);

    }
}
