package com.radix.asts.dto.response;

import java.time.LocalDate;

public record AssignmentResponseDTO(
        String astronautId,
        String astronautName,
        String satelliteId,
        String satelliteName,
        LocalDate assignedDate,
        String missionRole
) {}