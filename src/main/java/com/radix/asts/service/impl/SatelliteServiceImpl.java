package com.radix.asts.service.impl;

import com.radix.asts.dto.request.SatelliteRequestDTO;
import com.radix.asts.dto.response.SatelliteResponseDTO;
import com.radix.asts.model.Satellite;
import com.radix.asts.repository.SatelliteRepository;
import com.radix.asts.service.SatelliteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository repository;

    public SatelliteServiceImpl(SatelliteRepository repository) {
        this.repository = repository;
    }

    @Override
    public SatelliteResponseDTO createSatellite(SatelliteRequestDTO dto) {
        Satellite satellite = Satellite.builder()
                .satelliteId(dto.satelliteId())
                .name(dto.name())
                .launchDate(dto.launchDate())
                .status(dto.status())
                .build();
        repository.save(satellite);
        return toDTO(satellite);
    }

    @Override
    public List<SatelliteResponseDTO> getAllSatellites() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public SatelliteResponseDTO getBySatelliteId(String satelliteId) {
        Satellite s = repository.findBySatelliteId(satelliteId)
                .orElseThrow(() -> new RuntimeException("Satellite not found"));
        return toDTO(s);
    }

    @Override
    public SatelliteResponseDTO updateSatellite(SatelliteRequestDTO dto) {
        Satellite existing = repository.findBySatelliteId(dto.satelliteId())
                .orElseThrow(() -> new RuntimeException("Satellite not found"));

        if ("DECOMMISSIONED".equalsIgnoreCase(existing.getStatus())) {
            throw new RuntimeException("Cannot update a DECOMMISSIONED satellite.");
        }

        existing.setName(dto.name());
        existing.setLaunchDate(dto.launchDate());
        existing.setStatus(dto.status());

        repository.save(existing);
        return toDTO(existing);
    }

    private SatelliteResponseDTO toDTO(Satellite s) {
        return new SatelliteResponseDTO(
                s.getSatelliteId(),
                s.getName(),
                s.getLaunchDate(),
                s.getStatus()
        );
    }
}