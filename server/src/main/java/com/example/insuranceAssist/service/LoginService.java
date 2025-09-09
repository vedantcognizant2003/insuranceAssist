package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    public String verify(LoginRequestDTO request) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(request.getUsername());
        }
        else{
            return "Failed";
        }
    }
}
