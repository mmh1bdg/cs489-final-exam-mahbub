package com.radix.asts.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "astronauts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "astronaut_id", nullable = false, unique = true)
    private String astronautId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "astronaut", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AstronautSatellite> assignments = new ArrayList<>();
}