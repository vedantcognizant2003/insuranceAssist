package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.Exception.DependentNotFoundException;
import com.example.insuranceAssist.dto.DependentCreationDTORequest;
import com.example.insuranceAssist.dto.DependentDetailsDTO;
import com.example.insuranceAssist.dto.DependentProfileViewDTO;
import com.example.insuranceAssist.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/dependent")
public class DependentController {

    @Autowired
    private DependentService dependentService;

    @PostMapping("/create")
    public ResponseEntity<UUID> createDependent(@RequestBody DependentCreationDTORequest request){
        UUID dependentId = dependentService.createDependent(request);
        return new ResponseEntity<>(dependentId, HttpStatus.CREATED);
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<?> getDependents(@PathVariable UUID clientId){
        List<DependentProfileViewDTO> response = dependentService.getDependents(clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDetails/{dependentId}")
    public ResponseEntity<?> getDependentDetails(@PathVariable UUID dependentId){
        try{
            DependentDetailsDTO response = dependentService.getDependentDetails(dependentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (DependentNotFoundException e){
            return new ResponseEntity<>("Dependent Not Found", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update/{dependentId}")
    public ResponseEntity<?> updateDependent(@PathVariable UUID dependentId, @RequestBody DependentCreationDTORequest request){
        DependentDetailsDTO response = dependentService.updateDependent(dependentId, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dependentId}")
    public ResponseEntity<String> deleteDependent(@PathVariable UUID dependentId){
        dependentService.deleteDependent(dependentId);
        return new ResponseEntity<>("Dependent details deleted successfully", HttpStatus.OK);
    }
}
