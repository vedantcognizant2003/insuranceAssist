package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.Exception.ClientNotFoundException;
import com.example.insuranceAssist.Exception.DependentNotFoundException;
import com.example.insuranceAssist.Exception.RelationNotFoundException;
import com.example.insuranceAssist.dto.DependentCreationDTORequest;
import com.example.insuranceAssist.dto.DependentDetailsDTO;
import com.example.insuranceAssist.dto.DependentProfileViewDTO;
import com.example.insuranceAssist.service.DependentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/dependent")
public class DependentController {

    private final DependentService dependentService;

    public DependentController(DependentService dependentService){
        this.dependentService = dependentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDependent(@RequestBody DependentCreationDTORequest request){
        try{
            UUID dependentId = dependentService.createDependent(request);
            return new ResponseEntity<>(dependentId, HttpStatus.CREATED);
        } catch (ClientNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RelationNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<?> getDependents(@PathVariable UUID clientId){
        try{
            List<DependentProfileViewDTO> response = dependentService.getDependents(clientId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(ClientNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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
        try{
            DependentDetailsDTO response = dependentService.updateDependent(dependentId, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DependentNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{dependentId}")
    public ResponseEntity<String> deleteDependent(@PathVariable UUID dependentId){
        dependentService.deleteDependent(dependentId);
        return new ResponseEntity<>("Dependent details deleted successfully", HttpStatus.OK);
    }
}
