package com.example.insuranceAssist.service;

import com.example.insuranceAssist.dto.HospitalCreateUpdateRequestDTO;
import com.example.insuranceAssist.entity.HospitalMaster;
import com.example.insuranceAssist.repository.HospitalMasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalService {

    private final HospitalMasterRepository hospitalMasterRepository;

    public HospitalService(HospitalMasterRepository hospitalMasterRepository){
        this.hospitalMasterRepository = hospitalMasterRepository;
    }

    public UUID createHospital(HospitalCreateUpdateRequestDTO request){

//        HospitalMaster hospital = hospitalMasterRepository.findByEmail(request.getEmail());
//        if (hospital != null) {
//            System.out.println("hospital already exist");
//            throw new HospitalExistsException("This hospital already exist");
//        }

        System.out.println(request.getName());
        System.out.println(request.getAddress());
        System.out.println(request.getEmail());
        System.out.println(request.getBeds());
        System.out.println(request.getRating());
        System.out.println(request.getClientContactEmail());
        System.out.println(request.getClientContactNumber());
        System.out.println(request.getNetwork());

        HospitalMaster hospitalDetails = new HospitalMaster(
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getBeds(),
                request.getRating(),
                request.getClientContactEmail(),
                request.getClientContactNumber(),
                request.getNetwork()
        );

        HospitalMaster response = hospitalMasterRepository.save(hospitalDetails);

        return response.getId();

    }

    public UUID updateHospital(HospitalCreateUpdateRequestDTO request, UUID id){

        HospitalMaster hospitalDetails = hospitalMasterRepository.findById(id).orElseThrow();

        hospitalDetails.setName(request.getName());
        hospitalDetails.setAddress(request.getAddress());
        hospitalDetails.setEmail(request.getEmail());
        hospitalDetails.setBeds(request.getBeds());
        hospitalDetails.setRating(request.getRating());
        hospitalDetails.setClientContactEmail(request.getClientContactEmail());
        hospitalDetails.setClientContactNumber(request.getClientContactNumber());
        hospitalDetails.setNetwork(request.getNetwork());

        HospitalMaster response = hospitalMasterRepository.save(hospitalDetails);
        return response.getId();

    }

    public void deleteHospital(UUID id){
        hospitalMasterRepository.deleteById(id);
    }

    public List<HospitalMaster> getAllHospital(){
        return hospitalMasterRepository.findAll();
    }



}
