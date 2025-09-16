package com.example.insuranceAssist.service;

import com.example.insuranceAssist.exception.ClientNotFoundException;
import com.example.insuranceAssist.exception.DependentNotFoundException;
import com.example.insuranceAssist.exception.RelationNotFoundException;
import com.example.insuranceAssist.dto.DependentCreationRequestDTO;
import com.example.insuranceAssist.dto.DependentDetailsDTO;
import com.example.insuranceAssist.dto.DependentProfileViewDTO;
import com.example.insuranceAssist.entity.DependentMaster;
import com.example.insuranceAssist.entity.RelationTypeMaster;
import com.example.insuranceAssist.entity.UserMaster;
import com.example.insuranceAssist.repository.DependentMasterRepository;
import com.example.insuranceAssist.repository.RelationTypeMasterRepository;
import com.example.insuranceAssist.repository.UserMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DependentService {

    @Autowired
    private UserMasterRepository userMasterRepository;
    
    @Autowired
    private RelationTypeMasterRepository relationTypeMasterRepository;
    
    @Autowired
    private DependentMasterRepository dependentMasterRepository;

    public UUID createDependent(DependentCreationRequestDTO request) throws ClientNotFoundException, RelationNotFoundException {
        
        UserMaster client = userMasterRepository.findById(request.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found with clientId: " + request.getClientId()));
        
        RelationTypeMaster relation = relationTypeMasterRepository.findById(request.getRelationTypeId())
                .orElseThrow(() -> new RelationNotFoundException("Relation not found with relationId: " + request.getRelationTypeId()));
        
        DependentMaster dependentDetails = new DependentMaster(
                request.getName(),
                request.getDob(),
                request.getPhone(),
                request.getAddress(),
                relation,
                request.getGender(),
                request.getEmail(),
                client,
                LocalDateTime.now()
        );
        
        DependentMaster dep = dependentMasterRepository.save(dependentDetails);
        return dep.getId();
        
    }

    public List<DependentProfileViewDTO> getDependents(UUID clientId) throws ClientNotFoundException {

        UserMaster client = userMasterRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with clientId: " + clientId));

        List<DependentMaster> dependents = dependentMasterRepository.findByClient(client);

        List<DependentProfileViewDTO> response = new ArrayList<>();

        for(DependentMaster dependent: dependents){
            DependentProfileViewDTO dependentProfile = new DependentProfileViewDTO(
                dependent.getId(),
                dependent.getName(),
                dependent.getGender(),
                dependent.getRelationType().getRelationName(),
                dependent.getDob()
            );
            response.add(dependentProfile);
        }

        return response;

    }

    public DependentDetailsDTO getDependentDetails(UUID dependentId) throws DependentNotFoundException {

        DependentMaster dependent = dependentMasterRepository.findById(dependentId)
                .orElseThrow(() -> new DependentNotFoundException("Dependent not found with dependentId: " + dependentId));

        return new DependentDetailsDTO(
                dependent.getId(),
                dependent.getName(),
                dependent.getDob(),
                dependent.getRelationType().getRelationName(),
                dependent.getGender(),
                dependent.getAddress(),
                dependent.getEmail(),
                dependent.getPhone()
        );

    }

    public DependentDetailsDTO updateDependent(UUID dependentId, DependentCreationRequestDTO request) throws DependentNotFoundException {

        DependentMaster dependent = dependentMasterRepository.findById(dependentId)
                .orElseThrow(() -> new DependentNotFoundException("Dependent not found with dependentId: " + dependentId));

        dependent.setName(request.getName());
        dependent.setDob(request.getDob());
        dependent.setEmail(request.getEmail());
        dependent.setGender(request.getGender());
        dependent.setPhone(request.getPhone());
        dependent.setAddress(request.getAddress());
        dependent.setLastUpdated(LocalDateTime.now());

        dependentMasterRepository.save(dependent);

        return new DependentDetailsDTO(
                dependentId,
                dependent.getName(),
                dependent.getDob(),
                dependent.getRelationType().getRelationName(),
                dependent.getGender(),
                dependent.getAddress(),
                dependent.getEmail(),
                dependent.getPhone()
        );

    }

    public void deleteDependent(UUID dependentId) {

        dependentMasterRepository.deleteById(dependentId);

    }
}
