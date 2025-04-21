package com.radix.asts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AssignmentRequestDTO(
        @NotBlank String astronautId,
        @NotBlank String satelliteId,
        @NotNull LocalDate assignedDate,
        @NotBlank String missionRole
) {}