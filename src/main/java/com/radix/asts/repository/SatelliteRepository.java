package com.radix.asts.repository;

import com.radix.asts.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SatelliteRepository extends JpaRepository<Satellite, Integer> {
    Optional<Satellite> findBySatelliteId(String satelliteId);
}