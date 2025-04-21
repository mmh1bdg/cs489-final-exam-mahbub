package com.radix.asts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SatelliteRequestDTO(
        @NotBlank String satelliteId,
        @NotBlank String name,
        @NotNull LocalDate launchDate,
        @NotBlank String status
) {}