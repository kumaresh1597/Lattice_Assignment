package com.example.Lattice_Assignment.Controllers;

import com.example.Lattice_Assignment.DTOs.RequestDtos.PatientEntryDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorResponseDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorSuggestDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.PatientResponseDto;
import com.example.Lattice_Assignment.Exception.PatientNotFoundException;
import com.example.Lattice_Assignment.Services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
@Validated
public class PatientController {

    @Autowired
    private PatientService patientService;
    @PostMapping("/addPatient")
    public PatientResponseDto addPatient(@RequestBody @Valid PatientEntryDto patientEntryDto){
        return patientService.addPatient(patientEntryDto);
    }

    @GetMapping("/suggestDoctors")
    public List<DoctorSuggestDto> suggestDoctors(@RequestParam("patientId") int patientId){
        List<DoctorSuggestDto> doctorSuggestDtoList = new ArrayList<>();
        try {
            doctorSuggestDtoList = patientService.suggestDoctors(patientId);
            return doctorSuggestDtoList;
        } catch (Exception e) {
            DoctorSuggestDto doctorSuggestDto = new DoctorSuggestDto();
            doctorSuggestDto.setStatusCode("400");
            doctorSuggestDto.setStatusMessage(e.getMessage());
            doctorSuggestDtoList.add(doctorSuggestDto);
            return doctorSuggestDtoList;
        }
    }

    @DeleteMapping("/removePatient")
    public String removePatient(@RequestParam("patientId") int patientId){
        try {
            return patientService.removePatient(patientId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
