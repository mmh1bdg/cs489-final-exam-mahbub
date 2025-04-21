package com.radix.asts.dto.response;

public record AstronautResponseDTO(
        String astronautId,
        String fullName,
        String nationality,
        String aNationality, Boolean isActive
) {}