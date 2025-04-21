package com.radix.asts.service.impl;

import com.radix.asts.dto.request.AstronautRequestDTO;
import com.radix.asts.dto.response.AstronautResponseDTO;
import com.radix.asts.model.Astronaut;
import com.radix.asts.repository.AstronautRepository;
import com.radix.asts.service.AstronautService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository repository;

    public AstronautServiceImpl(AstronautRepository repository) {
        this.repository = repository;
    }

    @Override
    public AstronautResponseDTO createAstronaut(AstronautRequestDTO dto) {
        Astronaut astronaut = Astronaut.builder()
                .astronautId(dto.astronautId())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .nationality(dto.nationality())
                .isActive(dto.isActive())
                .build();
        repository.save(astronaut);
        return new AstronautResponseDTO(astronaut.getAstronautId(),
                astronaut.getFirstName() + " " + astronaut.getLastName(),
                astronaut.getNationality(),
                astronaut.getIsActive());
    }

    @Override
    public List<AstronautResponseDTO> getAllAstronauts() {
        return repository.findAll().stream()
                .map(a -> new AstronautResponseDTO(
                        a.getAstronautId(),
                        a.getFirstName() + " " + a.getLastName(),
                        a.getNationality(),
                        a.getIsActive()))
                .toList();
    }

    @Override
    public AstronautResponseDTO getByAstronautId(String astronautId) {
        Astronaut a = repository.findByAstronautId(astronautId)
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));
        return new AstronautResponseDTO(
                a.getAstronautId(),
                a.getFirstName() + " " + a.getLastName(),
                a.getNationality(),
                a.getIsActive());
    }
}