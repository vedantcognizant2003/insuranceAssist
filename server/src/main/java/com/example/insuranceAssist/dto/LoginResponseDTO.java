package com.example.insuranceAssist.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class LoginResponseDTO {

    String token;
    String role;
    UUID userId;
    String username;

    public LoginResponseDTO(String token, String role, UUID userId, String username) {
        this.token = token;
        this.role = role;
        this.userId = userId;
        this.username = username;
    }
}
