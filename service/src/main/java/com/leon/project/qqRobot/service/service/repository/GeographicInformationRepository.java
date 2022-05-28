package com.leon.project.qqRobot.service.service.repository;

import com.leon.project.qqRobot.service.service.model.GeographicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeographicInformationRepository extends JpaRepository<GeographicInformation, Long> {
    GeographicInformation findByAddress(String address);
}
