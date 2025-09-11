package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.dto.PolicyCreateRequestDTO;
import com.example.insuranceAssist.dto.PolicyResponseDTO;
import com.example.insuranceAssist.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/policy")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }

//    @PostMapping("/create")
//    public ResponseEntity<UUID> createPolicy(@RequestBody PolicyCreateRequestDTO request){
//        UUID policyId = policyService.createPolicy(request);
//        return new ResponseEntity<>(policyId, HttpStatus.CREATED);
//    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<PolicyResponseDTO> getPolicy(@PathVariable UUID clientId){
        PolicyResponseDTO response = policyService.getPolicy(clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
