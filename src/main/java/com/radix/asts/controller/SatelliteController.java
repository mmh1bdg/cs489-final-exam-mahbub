package com.radix.asts.controller;

import com.radix.asts.dto.request.SatelliteRequestDTO;
import com.radix.asts.dto.response.SatelliteResponseDTO;
import com.radix.asts.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satellites")
public class SatelliteController {

    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @PostMapping
    public ResponseEntity<SatelliteResponseDTO> create(@RequestBody @Valid SatelliteRequestDTO dto) {
        return ResponseEntity.ok(satelliteService.createSatellite(dto));
    }

    @GetMapping
    public ResponseEntity<List<SatelliteResponseDTO>> getAll() {
        return ResponseEntity.ok(satelliteService.getAllSatellites());
    }

    @GetMapping("/{satelliteId}")
    public ResponseEntity<SatelliteResponseDTO> getById(@PathVariable String satelliteId) {
        return ResponseEntity.ok(satelliteService.getBySatelliteId(satelliteId));
    }

    @PutMapping
    public ResponseEntity<SatelliteResponseDTO> update(@RequestBody @Valid SatelliteRequestDTO dto) {
        return ResponseEntity.ok(satelliteService.updateSatellite(dto));
    }
}