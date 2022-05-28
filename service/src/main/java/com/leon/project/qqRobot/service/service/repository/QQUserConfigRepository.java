package com.leon.project.qqRobot.service.service.repository;

import com.leon.project.qqRobot.service.service.model.QQUserConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QQUserConfigRepository extends JpaRepository<QQUserConfig, Long> {
    QQUserConfig findByQq(String qq);
}
