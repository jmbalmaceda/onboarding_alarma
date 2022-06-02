package com.onboarding.vitalsigns.repository;

import com.onboarding.vitalsigns.entity.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign,Integer> {
}
