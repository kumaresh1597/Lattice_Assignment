package com.example.Lattice_Assignment.Transformers;

import com.example.Lattice_Assignment.DTOs.RequestDtos.PatientEntryDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.PatientResponseDto;
import com.example.Lattice_Assignment.Enums.Symptoms;
import com.example.Lattice_Assignment.Models.Patient;

public class PatientTransformer {

    public static Patient convertEntryDtoToEntity(PatientEntryDto patientEntryDto){

        String patientSymptom = patientEntryDto.getSymptom();
        patientSymptom =  patientSymptom.toUpperCase().replaceAll("\\s", "");


        Patient patient = Patient.builder().name(patientEntryDto.getName())
                .city(patientEntryDto.getCity())
                .email(patientEntryDto.getEmail())
                .mobile(patientEntryDto.getMobile())
                .symptom(Symptoms.valueOf(patientSymptom))
                .build();

        return patient;
    }

    public static PatientResponseDto covertEntityToDto(Patient patient){
        PatientResponseDto patientResponseDto = PatientResponseDto.builder()
                .name(patient.getName())
                .city(patient.getCity())
                .email(patient.getEmail())
                .mobile(patient.getMobile())
                .symptom(patient.getSymptom())
                .build();

        return patientResponseDto;
    }
}
