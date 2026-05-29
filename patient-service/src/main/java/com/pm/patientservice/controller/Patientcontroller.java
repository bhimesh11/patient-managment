package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validationRequest.CreatePatientValidationGroup;
import com.pm.patientservice.exceptions.EmailAlreadyExistsException;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing Patients")//http:local
public class Patientcontroller {

    private final PatientService patientService;

    public Patientcontroller(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get List of patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patientResponseDTOS = patientService.getPatients();
        return ResponseEntity.ok().body(patientResponseDTOS);
    }

    @PostMapping
    @Operation(summary = "Created a new Patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody
                                                            @Validated({Default.class, CreatePatientValidationGroup.class}) PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        PatientResponseDTO patient = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patient);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing patient details")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient")
    public ResponseEntity<Void> updatePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
