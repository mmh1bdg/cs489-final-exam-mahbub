package com.radix.asts.service;

import com.radix.asts.dto.request.AstronautRequestDTO;
import com.radix.asts.dto.response.AstronautResponseDTO;

import java.util.List;

public interface AstronautService {
    AstronautResponseDTO createAstronaut(AstronautRequestDTO dto);
    List<AstronautResponseDTO> getAllAstronauts();
    AstronautResponseDTO getByAstronautId(String astronautId);
}