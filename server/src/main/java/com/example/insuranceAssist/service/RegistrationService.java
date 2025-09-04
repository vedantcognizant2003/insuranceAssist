package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.RegistrationRequestDTO;
import com.example.insuranceAssist.entity.RoleMaster;
import com.example.insuranceAssist.entity.UserMaster;
import com.example.insuranceAssist.repository.RoleMasterRepository;
import com.example.insuranceAssist.repository.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserMasterRepository userMasterRepository;
    @Autowired
    private RoleMasterRepository roleMasterRepository;

    public void register(RegistrationRequestDTO request) {

        String[] emailParts = request.getEmail().split("@");
        int atInd = emailParts[1].indexOf('.');
        String username = emailParts[0] + emailParts[1].substring(0, atInd);

        RoleMaster clientRole = roleMasterRepository.findById(1L).orElseThrow();

        UserMaster user = new UserMaster(
                username,
                request.getPassword(),
                request.getName(),
                request.getGender(),
                request.getDob(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress(),
                clientRole
        );

        userMasterRepository.save(user);
    }
}
