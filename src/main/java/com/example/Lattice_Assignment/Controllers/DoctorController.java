package com.example.Lattice_Assignment.Controllers;

import com.example.Lattice_Assignment.DTOs.RequestDtos.DoctorEntryDTO;
import com.example.Lattice_Assignment.DTOs.RequestDtos.PatientEntryDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorResponseDto;
import com.example.Lattice_Assignment.Exception.DoctorNotFoundException;
import com.example.Lattice_Assignment.Models.Doctor;
import com.example.Lattice_Assignment.Services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public DoctorResponseDto addDoctor(@RequestBody @Valid DoctorEntryDTO doctorEntryDTO){
        return doctorService.addDoctor((doctorEntryDTO));
    }

    @DeleteMapping("/removeDoctor")
    public String removeDoctor(@RequestParam("doctorId") int doctorId){
        try {
            return doctorService.removeDoctor(doctorId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
