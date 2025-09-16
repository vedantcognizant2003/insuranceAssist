package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.dto.ClaimCreateRequestDTO;
import com.example.insuranceAssist.dto.ClaimResponseDTO;
import com.example.insuranceAssist.exception.*;
import com.example.insuranceAssist.service.ClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/claim")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/create")
    public ResponseEntity<UUID> createClaim(@RequestBody ClaimCreateRequestDTO request) throws ClientNotFoundException, StatusTypeNotFoundException, ClaimTypeNotFoundException {
        UUID claimId = claimService.createClaim(request);
        return new ResponseEntity<>(claimId, HttpStatus.CREATED);
    }

    @GetMapping("/get/{claimId}")
    public ResponseEntity<ClaimResponseDTO> getClaim(@PathVariable UUID claimId) throws ClaimNotFoundException {
        ClaimResponseDTO response = claimService.getClaim(claimId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/agent/{agentId}")
    public ResponseEntity<List<ClaimResponseDTO>> getClaimByAgent(@PathVariable UUID agentId) throws AgentNotFoundException {
        List<ClaimResponseDTO> response = claimService.getClaimByAgent(agentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<List<ClaimResponseDTO>> getClaimByClient(@PathVariable UUID clientId) throws ClientNotFoundException {
        List<ClaimResponseDTO> response = claimService.getClaimByClient(clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{claimId}/{updatedStatus}")
    public ResponseEntity<ClaimResponseDTO> updateClaim(@PathVariable UUID claimId, @PathVariable Long updatedStatus) throws ClaimNotFoundException, StatusTypeNotFoundException {
        ClaimResponseDTO response = claimService.updateClaim(claimId, updatedStatus);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{claimId}")
    public ResponseEntity<String> deleteClaim(@PathVariable UUID claimId){
        claimService.deleteClaim(claimId);
        return new ResponseEntity<>("Claim deleted successfully", HttpStatus.OK);
    }

}
