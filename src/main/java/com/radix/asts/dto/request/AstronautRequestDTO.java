package com.radix.asts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AstronautRequestDTO(
        @NotBlank String astronautId,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String nationality,
        @NotNull Boolean isActive
) {}