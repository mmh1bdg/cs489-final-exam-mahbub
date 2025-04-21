package com.radix.asts.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "astronaut_satellite",
        uniqueConstraints = @UniqueConstraint(columnNames = {"astronaut_id", "satellite_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AstronautSatellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Reference to Astronaut (many-to-one)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "astronaut_id", referencedColumnName = "astronaut_id", nullable = false)
    private Astronaut astronaut;

    // Reference to Satellite (many-to-one)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satellite_id", referencedColumnName = "satellite_id", nullable = false)
    private Satellite satellite;

    @Column(name = "assigned_date", nullable = false)
    private LocalDate assignedDate;

    @Column(name = "mission_role")
    private String missionRole;
}