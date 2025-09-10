package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.service.PolicyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private/policy")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }

//    @GetMapping("/get/{clientId}")
//    public

}
