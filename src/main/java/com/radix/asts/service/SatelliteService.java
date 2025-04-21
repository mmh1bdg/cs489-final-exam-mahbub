package com.radix.asts.service;

import com.radix.asts.dto.request.SatelliteRequestDTO;
import com.radix.asts.dto.response.SatelliteResponseDTO;

import java.util.List;

public interface SatelliteService {
    SatelliteResponseDTO createSatellite(SatelliteRequestDTO dto);
    List<SatelliteResponseDTO> getAllSatellites();
    SatelliteResponseDTO getBySatelliteId(String satelliteId);
    SatelliteResponseDTO updateSatellite(SatelliteRequestDTO dto);
}