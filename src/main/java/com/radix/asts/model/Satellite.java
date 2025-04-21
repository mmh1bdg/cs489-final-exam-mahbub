package com.radix.asts.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "satellites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "satellite_id", nullable = false, unique = true)
    private String satelliteId;

    @Column(nullable = false)
    private String name;

    @Column(name = "launch_date", nullable = false)
    private LocalDate launchDate;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "satellite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AstronautSatellite> assignments = new ArrayList<>();
}