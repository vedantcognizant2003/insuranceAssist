package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.Exception.PolicyNotFoundException;
import com.example.insuranceAssist.Exception.PolicyTypeNotFoundException;
import com.example.insuranceAssist.Exception.UserNotFoundException;
import com.example.insuranceAssist.dto.PolicyCreateRequestDTO;
import com.example.insuranceAssist.dto.PolicyResponseDTO;
import com.example.insuranceAssist.service.PolicyService;
import org.apache.coyote.Response;
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

    @PostMapping("/create")
    public ResponseEntity<?> createPolicy(@RequestBody PolicyCreateRequestDTO request){
        try{
            UUID policyId = policyService.createPolicy(request);
            return new ResponseEntity<>(policyId, HttpStatus.CREATED);
        } catch (PolicyTypeNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{policyId}")
    public ResponseEntity<?> getPolicy(@PathVariable UUID policyId){
        try {
            PolicyResponseDTO response = policyService.getPolicy(policyId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (PolicyNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{policyId}")
    public ResponseEntity<?> updatePolicy(@PathVariable UUID policyId, @RequestBody PolicyCreateRequestDTO request){
        try{
            PolicyResponseDTO response = policyService.updatePolicy(policyId, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (PolicyTypeNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (PolicyNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{policyId}")
    public ResponseEntity<String> deletePolicy(@PathVariable UUID policyId){
        policyService.deletePolicy(policyId);
        return new ResponseEntity<>("Policy Deleted Successfully", HttpStatus.OK);
    }

}
