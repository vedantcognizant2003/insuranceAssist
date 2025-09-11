package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.Exception.HospitalNotFoundException;
import com.example.insuranceAssist.dto.HospitalCreateRequestDTO;
import com.example.insuranceAssist.dto.HospitalDetailsResponseDTO;
import com.example.insuranceAssist.dto.HospitalResponseDTO;
import com.example.insuranceAssist.service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    
    public ResponseEntity<UUID> createHospital(@RequestBody HospitalCreateRequestDTO request){
        UUID hospitalId = hospitalService.create(request);
        return new ResponseEntity<>(hospitalId, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<HospitalResponseDTO>> getHospital(){
        List<HospitalResponseDTO> hospitalList = hospitalService.getHospital();
        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    @GetMapping("/get/{hospitalId}")
    public ResponseEntity<?> getHospitalDetails(@PathVariable UUID hospitalId){
        try{
            HospitalDetailsResponseDTO hospital = hospitalService.getHospitalDetails(hospitalId);
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } catch (HospitalNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PutMapping("/update/{hospitalId}")
    public ResponseEntity<?> updateHospital(@RequestBody HospitalCreateRequestDTO request, @PathVariable UUID hospitalId) {
        try{
            HospitalDetailsResponseDTO hospital = hospitalService.updateHospital(request, hospitalId);
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        }catch (HospitalNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{hospitalId}")
    public ResponseEntity<String> deleteHospital(@PathVariable UUID hospitalId){
        hospitalService.deleteHospital(hospitalId);
        return new ResponseEntity<>("Hospital information deleted successfully", HttpStatus.OK);
    }

}
