package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.dto.RegistrationRequestDTO;
import com.example.insuranceAssist.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequestDTO request){
        request.setPassword(encoder.encode(request.getPassword()));
        registrationService.register(request);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

}
