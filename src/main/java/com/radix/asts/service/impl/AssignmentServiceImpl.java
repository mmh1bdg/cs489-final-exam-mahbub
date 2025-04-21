package com.radix.asts.service.impl;

import com.radix.asts.dto.request.AssignmentRequestDTO;
import com.radix.asts.dto.response.AssignmentResponseDTO;
import com.radix.asts.model.Astronaut;
import com.radix.asts.model.AstronautSatellite;
import com.radix.asts.model.Satellite;
import com.radix.asts.repository.AstronautRepository;
import com.radix.asts.repository.AssignmentRepository;
import com.radix.asts.repository.SatelliteRepository;
import com.radix.asts.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository,
                                 AstronautRepository astronautRepository,
                                 SatelliteRepository satelliteRepository) {
        this.assignmentRepository = assignmentRepository;
        this.astronautRepository = astronautRepository;
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public AssignmentResponseDTO assignAstronautToSatellite(AssignmentRequestDTO dto) {
        Astronaut astronaut = astronautRepository.findByAstronautId(dto.astronautId())
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));
        Satellite satellite = satelliteRepository.findBySatelliteId(dto.satelliteId())
                .orElseThrow(() -> new RuntimeException("Satellite not found"));

        AstronautSatellite assignment = AstronautSatellite.builder()
                .astronaut(astronaut)
                .satellite(satellite)
                .assignedDate(dto.assignedDate())
                .missionRole(dto.missionRole())
                .build();

        assignmentRepository.save(assignment);

        return new AssignmentResponseDTO(
                astronaut.getAstronautId(),
                astronaut.getFirstName() + " " + astronaut.getLastName(),
                satellite.getSatelliteId(),
                satellite.getName(),
                dto.assignedDate(),
                dto.missionRole()
        );
    }

    @Override
    public List<AssignmentResponseDTO> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(as -> new AssignmentResponseDTO(
                        as.getAstronaut().getAstronautId(),
                        as.getAstronaut().getFirstName() + " " + as.getAstronaut().getLastName(),
                        as.getSatellite().getSatelliteId(),
                        as.getSatellite().getName(),
                        as.getAssignedDate(),
                        as.getMissionRole()))
                .toList();
    }

    @Override
    public AssignmentResponseDTO updateAssignment(String assignmentId, AssignmentRequestDTO dto) {
        // Convert String to Integer
        int id = Integer.parseInt(assignmentId);

        AstronautSatellite assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        Astronaut astronaut = astronautRepository.findByAstronautId(dto.astronautId())
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));
        Satellite satellite = satelliteRepository.findBySatelliteId(dto.satelliteId())
                .orElseThrow(() -> new RuntimeException("Satellite not found"));

        assignment.setAstronaut(astronaut);
        assignment.setSatellite(satellite);
        assignment.setAssignedDate(dto.assignedDate());
        assignment.setMissionRole(dto.missionRole());

        assignmentRepository.save(assignment);

        return new AssignmentResponseDTO(
                astronaut.getAstronautId(),
                astronaut.getFirstName() + " " + astronaut.getLastName(),
                satellite.getSatelliteId(),
                satellite.getName(),
                dto.assignedDate(),
                dto.missionRole()
        );
    }
}