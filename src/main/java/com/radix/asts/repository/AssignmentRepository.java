package com.radix.asts.repository;

import com.radix.asts.model.AstronautSatellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AstronautSatellite, Integer> {
}