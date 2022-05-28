package com.leon.project.qqRobot.service.service.repository;

import com.leon.project.qqRobot.service.service.model.QQWarningRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QQWarningRecordRepository extends JpaRepository<QQWarningRecord, Long> {
    QQWarningRecord findByWarningIdAndQqUserId(String warningId, Long qqUserId);
}

