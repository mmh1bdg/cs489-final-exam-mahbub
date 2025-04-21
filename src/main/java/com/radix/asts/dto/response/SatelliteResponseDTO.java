package com.radix.asts.dto.response;

import java.time.LocalDate;

public record SatelliteResponseDTO(
        String satelliteId,
        String name,
        LocalDate launchDate,
        String status
) {}