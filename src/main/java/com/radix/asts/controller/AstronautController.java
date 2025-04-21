package com.radix.asts.controller;

import com.radix.asts.dto.request.AstronautRequestDTO;
import com.radix.asts.dto.response.AstronautResponseDTO;
import com.radix.asts.service.AstronautService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/astronauts")
public class AstronautController {

    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @PostMapping
    public ResponseEntity<AstronautResponseDTO> create(@RequestBody @Valid AstronautRequestDTO dto) {
        return ResponseEntity.ok(astronautService.createAstronaut(dto));
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDTO>> getAll() {
        return ResponseEntity.ok(astronautService.getAllAstronauts());
    }

    @GetMapping("/{astronautId}")
    public ResponseEntity<AstronautResponseDTO> getById(@PathVariable String astronautId) {
        return ResponseEntity.ok(astronautService.getByAstronautId(astronautId));
    }
}