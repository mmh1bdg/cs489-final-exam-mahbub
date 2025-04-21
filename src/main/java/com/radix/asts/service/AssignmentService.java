package com.radix.asts.service;

import com.radix.asts.dto.request.AssignmentRequestDTO;
import com.radix.asts.dto.response.AssignmentResponseDTO;

import java.util.List;

public interface AssignmentService {
    AssignmentResponseDTO assignAstronautToSatellite(AssignmentRequestDTO dto);
    List<AssignmentResponseDTO> getAllAssignments();
    AssignmentResponseDTO updateAssignment(String assignmentId, AssignmentRequestDTO dto);
}