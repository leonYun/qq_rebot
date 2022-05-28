package com.leon.project.qqRobot.service.service.model;

import lombok.*;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "qq_warning_record",
        uniqueConstraints = {
                @UniqueConstraint(name = "idx_warning_id_qq_user_id", columnNames = {"warningId", "qqUserId"})
        }
)
public class QQWarningRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String warningId;

    /**
     * @see QQUserConfig#id
     */
    private Long qqUserId;
}
