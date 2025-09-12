package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.Exception.*;
import com.example.insuranceAssist.dto.ClaimCreateRequestDTO;
import com.example.insuranceAssist.dto.ClaimResponseDTO;
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
    public ResponseEntity<?> createClaim(@RequestBody ClaimCreateRequestDTO request){
        try{
            UUID claimId = claimService.createClaim(request);
            return new ResponseEntity<>(claimId, HttpStatus.CREATED);
        } catch (ClientNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch(ClaimTypeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (ClaimStatusNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/get/{claimId}")
    public ResponseEntity<?> getClaim(@PathVariable UUID claimId){
        try{
            ClaimResponseDTO response = claimService.getClaim(claimId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ClaimNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/agent/{agentId}")
    public ResponseEntity<?> getClaimByAgent(@PathVariable UUID agentId){
        try{
            List<ClaimResponseDTO> response = claimService.getClaimByAgent(agentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<?> getClaimByClient(@PathVariable UUID clientId){
        try{
            List<ClaimResponseDTO> response = claimService.getClaimByClient(clientId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{claimId}/{updatedStatus}")
    public ResponseEntity<?> updateClaim(@PathVariable UUID claimId, @PathVariable Long updatedStatus){
        try{
            ClaimResponseDTO response = claimService.updateClaim(claimId, updatedStatus);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ClaimNotFoundException e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{claimId}")
    public ResponseEntity<String> deleteClaim(@PathVariable UUID claimId){
        claimService.deleteClaim(claimId);
        return new ResponseEntity<>("Claim deleted successfully", HttpStatus.OK);
    }

}
