package com.example.insuranceAssist.service;

import com.example.insuranceAssist.repository.AgentMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentMasterService {

    private static AgentMasterRepository agentMasterRepository;

}
