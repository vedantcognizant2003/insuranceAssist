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

    @GetMapping("/get/{policyId}")
    public ResponseEntity<PolicyResponseDTO> getPolicy(@PathVariable UUID policyId){
        PolicyResponseDTO response = policyService.getPolicy(policyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{policyId}")
    public ResponseEntity<?> updatePolicy(@PathVariable UUID policyId, @RequestBody PolicyCreateRequestDTO request){
        PolicyResponseDTO response = policyService.updatePolicy(policyId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{policyId}")
    public ResponseEntity<String> deletePolicy(@PathVariable UUID policyId){
        policyService.deletePolicy(policyId);
        return new ResponseEntity<>("Policy Deleted Successfully", HttpStatus.OK);
    }

}
