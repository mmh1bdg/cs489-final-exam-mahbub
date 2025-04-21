package com.radix.asts.repository;

import com.radix.asts.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AstronautRepository extends JpaRepository<Astronaut, Integer> {
    Optional<Astronaut> findByAstronautId(String astronautId);
}