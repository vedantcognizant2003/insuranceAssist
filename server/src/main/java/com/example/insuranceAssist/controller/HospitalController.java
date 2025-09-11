package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.dto.HospitalCreateUpdateRequestDTO;
import com.example.insuranceAssist.entity.HospitalMaster;
import com.example.insuranceAssist.service.HospitalService;
import com.sun.net.httpserver.HttpsServer;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/private/hospital")
public class HospitalController {

    HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @PostMapping("/create")
    public ResponseEntity<UUID> createHospital(@RequestBody HospitalCreateUpdateRequestDTO request){
        UUID hospitalId = hospitalService.createHospital(request);
        return new ResponseEntity<>(hospitalId, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UUID> updateHospital(@PathVariable UUID id, @RequestBody HospitalCreateUpdateRequestDTO request){
        UUID hospitalId = hospitalService.updateHospital(request, id);
        return new ResponseEntity<>(hospitalId, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable UUID id){
        hospitalService.deleteHospital(id);
        return new ResponseEntity<>("Deleted hospital successfully", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<HospitalMaster>> getAllHospital(){
        List<HospitalMaster> allHospital = hospitalService.getAllHospital();
        return new ResponseEntity<>(allHospital, HttpStatus.OK);
    }



}
