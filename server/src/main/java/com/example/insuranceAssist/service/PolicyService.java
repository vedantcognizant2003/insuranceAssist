package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.PolicyCreateRequestDTO;
import com.example.insuranceAssist.dto.PolicyResponseDTO;
import com.example.insuranceAssist.entity.PolicyMaster;
import com.example.insuranceAssist.entity.PolicyTypeMaster;
import com.example.insuranceAssist.entity.UserMaster;
import com.example.insuranceAssist.repository.PolicyMasterRepository;
import com.example.insuranceAssist.repository.PolicyTypeMasterRepository;
import com.example.insuranceAssist.repository.UserMasterRepository;
import org.springframework.stereotype.Service;

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


    public PolicyResponseDTO getPolicy(UUID clientId) {
        UserMaster client = userMasterRepository.findById(clientId)
                .orElseThrow();

        PolicyMaster policy = policyMasterRepository.findByClient(client);

        PolicyTypeMaster policyType = policy.getPolicyType();

        return new PolicyResponseDTO(
                policy.getPolicyId(),
                policyType.getTier(),
                policy.getStartDate(),
                policy.getEndDate(),
                policy.getPremium()
        );

    }

//    public UUID createPolicy(PolicyCreateRequestDTO request) {
//
//        PolicyTypeMaster policyType = policyTypeMasterRepository.findById(request.getPolicyType())
//                .orElseThrow();
//
//        UserMaster client = userMasterRepository.findById(request.getClientId())
//                .orElseThrow();
//
//        Long prem = (long) (policyType.getPremiumBase() + ((long) request.getNoOfDependents() * policyType.getPremiumPerDependent()));
//
//        PolicyMaster policy = new PolicyMaster(
//                client,
//                request.getNoOfDependents(),
//                request.getStartDate(),
//                request.getEndDate(),
//                prem,
////                new List<Autho>
//        );
//
//    }
}
