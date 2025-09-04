package com.example.insuranceAssist.controller;

import com.example.insuranceAssist.entity.RoleMaster;
import com.example.insuranceAssist.entity.UserMaster;
import com.example.insuranceAssist.repository.RoleMasterRepository;
import com.example.insuranceAssist.repository.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

}
