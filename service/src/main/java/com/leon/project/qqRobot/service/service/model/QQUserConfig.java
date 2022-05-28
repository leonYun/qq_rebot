package com.leon.project.qqRobot.service.service.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "qq_user_config",
        uniqueConstraints = {
                @UniqueConstraint(name = "idx_qq", columnNames = {"qq"})
        }
)
public class QQUserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String qq;

    private String address;

    private Boolean enable;
}
