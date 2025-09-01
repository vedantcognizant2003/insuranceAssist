package com.example.insuranceAssist.repository;

import com.example.insuranceAssist.entity.PolicyNetworkTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyNetworkTableRepository extends JpaRepository<PolicyNetworkTable, Long> {
}
