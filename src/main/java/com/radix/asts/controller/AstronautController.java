package com.radix.asts.controller;

import com.radix.asts.dto.request.AstronautRequestDTO;
import com.radix.asts.dto.response.AstronautResponseDTO;
import com.radix.asts.service.AstronautService;
import jakarta.validation.Valid;
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
    public AstronautResponseDTO createAstronaut(@Valid @RequestBody AstronautRequestDTO dto) {
        return astronautService.createAstronaut(dto);
    }

    @GetMapping
    public List<AstronautResponseDTO> getAllAstronauts() {
        return astronautService.getAllAstronauts();
    }

    @GetMapping("/{astronautId}")
    public AstronautResponseDTO getAstronautById(@PathVariable String astronautId) {
        return astronautService.getAstronautById(astronautId);
    }

    @PutMapping
    public AstronautResponseDTO updateAstronaut(@Valid @RequestBody AstronautRequestDTO dto) {
        return astronautService.updateAstronaut(dto);
    }
}