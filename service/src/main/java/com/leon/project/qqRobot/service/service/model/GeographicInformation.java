package com.leon.project.qqRobot.service.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "geographic_information",
        uniqueConstraints = {
                @UniqueConstraint(name = "idx_address", columnNames = {"address"})
        }
)
public class GeographicInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    /**
     * 经度
     */
    private String lng;

    /**
     * 维度
     */
    private String lat;
}
