package com.radix.asts.controller;

import com.radix.asts.dto.request.AssignmentRequestDTO;
import com.radix.asts.dto.response.AssignmentResponseDTO;
import com.radix.asts.service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<AssignmentResponseDTO> assign(@RequestBody @Valid AssignmentRequestDTO dto) {
        return ResponseEntity.ok(assignmentService.assignAstronautToSatellite(dto));
    }

    @GetMapping
    public ResponseEntity<List<AssignmentResponseDTO>> getAll() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }
}