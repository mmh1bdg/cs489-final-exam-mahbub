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
        return mapToDTO(astronaut);
    }

    @Override
    public List<AstronautResponseDTO> getAllAstronauts() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public AstronautResponseDTO getAstronautById(String astronautId) {
        Astronaut astro = repository.findByAstronautId(astronautId)
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));
        return mapToDTO(astro);
    }

    @Override
    public AstronautResponseDTO updateAstronaut(AstronautRequestDTO dto) {
        Astronaut existing = repository.findByAstronautId(dto.astronautId())
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));

        existing.setFirstName(dto.firstName());
        existing.setLastName(dto.lastName());
        existing.setNationality(dto.nationality());
        existing.setIsActive(dto.isActive());

        repository.save(existing);
        return mapToDTO(existing);
    }

    private AstronautResponseDTO mapToDTO(Astronaut a) {
        return new AstronautResponseDTO(
                a.getAstronautId(),
                a.getFirstName(),
                a.getLastName(),
                a.getNationality(),
                a.getIsActive()
        );
    }
}