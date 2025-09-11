package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.ClaimCreateRequestDTO;
import com.example.insuranceAssist.dto.ClaimResponseDTO;
import com.example.insuranceAssist.entity.*;
import com.example.insuranceAssist.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClaimService {

    private final AuthorizationRepository authorizationRepository;
    private final AuthorizationLogRepository authorizationLogRepository;
    private final ClaimTypeMasterRepository claimTypeMasterRepository;
    private final UserMasterRepository userMasterRepository;
    private final PolicyMasterRepository policyMasterRepository;
    private final PolicyTypeMasterRepository policyTypeMasterRepository;
    private final StatusTypeMasterRepository statusTypeMasterRepository;
    private final AgentAllocationService agentAllocationService;

    public ClaimService(AuthorizationRepository authorizationRepository, AuthorizationLogRepository authorizationLogRepository, ClaimTypeMasterRepository claimTypeMasterRepository, UserMasterRepository userMasterRepository, PolicyMasterRepository policyMasterRepository, PolicyTypeMasterRepository policyTypeMasterRepository, StatusTypeMasterRepository statusTypeMasterRepository, AgentAllocationService agentAllocationService) {
        this.authorizationRepository = authorizationRepository;
        this.authorizationLogRepository = authorizationLogRepository;
        this.claimTypeMasterRepository = claimTypeMasterRepository;
        this.userMasterRepository = userMasterRepository;
        this.policyMasterRepository = policyMasterRepository;
        this.policyTypeMasterRepository = policyTypeMasterRepository;
        this.statusTypeMasterRepository = statusTypeMasterRepository;
        this.agentAllocationService = agentAllocationService;
    }

    public UUID createClaim(ClaimCreateRequestDTO request) {

        UserMaster client = userMasterRepository.findById(request.getClientId())
                .orElseThrow();

        UserMaster agent = agentAllocationService.getAllocatedAgent();

        PolicyMaster policy = policyMasterRepository.findByClient(client);

        PolicyTypeMaster policyType = policy.getPolicyType();

        ClaimTypeMaster claimType = claimTypeMasterRepository.findById(request.getClaimType())
                .orElseThrow();

        Long statusCreated = 1L;
        StatusTypeMaster status = statusTypeMasterRepository.findById(statusCreated)
                .orElseThrow();

        Authorization claim = new Authorization(
                policy,
                claimType,
                agent,
                client,
                request.getClaimAmount(),
                status,
                LocalDateTime.now(),
                null,
                request.getProcedureNotes(),
                LocalDateTime.now()
        );

        UUID claimId = authorizationRepository.save(claim).getId();
        AuthorizationLog log = new AuthorizationLog(
                policy,
                null,
                status,
                LocalDateTime.now()
        );

        authorizationLogRepository.save(log);
        return claimId;

    }

    public ClaimResponseDTO getClaim(UUID claimId) {

        Authorization claim = authorizationRepository.findById(claimId)
                .orElseThrow();

        return new ClaimResponseDTO(
            claim.getClient().getId(),
            claim.getPolicy().getPolicyId(),
            claim.getOpenDate(),
            claim.getProcedureNotes(),
            claim.getClaimType().getClaimType(),
            claim.getStatus().getStatusType(),
            claim.getClaimAmount()
        );

    }

    public List<ClaimResponseDTO> getClaimByAgent(UUID agentId) {

        UserMaster agent = userMasterRepository.findById(agentId)
                .orElseThrow();

        List<Authorization> claims = authorizationRepository.findAllByAgent(agent);

        List<ClaimResponseDTO> response = new ArrayList<>();

        for(Authorization claim: claims){
            ClaimResponseDTO dto = new ClaimResponseDTO(
                    claim.getId(),
                    claim.getPolicy().getPolicyId(),
                    claim.getOpenDate(),
                    claim.getProcedureNotes(),
                    claim.getClaimType().getClaimType(),
                    claim.getStatus().getStatusType(),
                    claim.getClaimAmount()
            );
            response.add(dto);
        }

        return response;

    }

    public List<ClaimResponseDTO> getClaimByClient(UUID clientId) {

        UserMaster client = userMasterRepository.findById(clientId)
                .orElseThrow();

        List<Authorization> claims = authorizationRepository.findAllByClient(client);

        List<ClaimResponseDTO> response = new ArrayList<>();

        for(Authorization claim: claims){
            ClaimResponseDTO dto = new ClaimResponseDTO(
                    claim.getId(),
                    claim.getPolicy().getPolicyId(),
                    claim.getOpenDate(),
                    claim.getProcedureNotes(),
                    claim.getClaimType().getClaimType(),
                    claim.getStatus().getStatusType(),
                    claim.getClaimAmount()
            );
            response.add(dto);
        }

        return response;

    }

    public ClaimResponseDTO updateClaim(UUID claimId, Long updatedStatus) {

        Authorization claim = authorizationRepository.findById(claimId)
                .orElseThrow();

        StatusTypeMaster currStatus = statusTypeMasterRepository.findById(updatedStatus)
                .orElseThrow();

        StatusTypeMaster prevStatus = claim.getStatus();

        claim.setStatus(currStatus);

        authorizationRepository.save(claim);

        AuthorizationLog log = new AuthorizationLog(
                claim.getPolicy(),
                prevStatus,
                currStatus,
                LocalDateTime.now()
        );

        authorizationLogRepository.save(log);

        return new ClaimResponseDTO(
                claim.getId(),
                claim.getPolicy().getPolicyId(),
                claim.getOpenDate(),
                claim.getProcedureNotes(),
                claim.getClaimType().getClaimType(),
                claim.getStatus().getStatusType(),
                claim.getClaimAmount()
        );

    }

    public void deleteClaim(UUID claimId) {

        authorizationRepository.deleteById(claimId);

    }

}
