package com.example.Lattice_Assignment.Transformers;

import com.example.Lattice_Assignment.DTOs.RequestDtos.DoctorEntryDTO;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorResponseDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorSuggestDto;
import com.example.Lattice_Assignment.Models.Doctor;
import com.example.Lattice_Assignment.Models.Patient;

public class DoctorTransformer {

    public static Doctor convertEntryDTOToEntity(DoctorEntryDTO doctorEntryDTO){
        Doctor doctor = Doctor.builder().name(doctorEntryDTO.getName())
                .city(doctorEntryDTO.getCity())
                .email(doctorEntryDTO.getEmail())
                .mobile(doctorEntryDTO.getMobile())
                .speciality(doctorEntryDTO.getSpeciality())
                .build();

        return doctor;
    }

    public static DoctorResponseDto convertEntityToDto(Doctor doctor){
        DoctorResponseDto doctorResponseDto = DoctorResponseDto.builder().name(doctor.getName())
                .city(doctor.getCity())
                .email(doctor.getEmail())
                .mobile(doctor.getMobile())
                .speciality(doctor.getSpeciality())
                .build();

        return doctorResponseDto;
    }


    public static DoctorSuggestDto convertEntityToDto(Doctor doctor, Patient patient) {
        DoctorSuggestDto doctorSuggestDto = DoctorSuggestDto.builder()
                .doctorName(doctor.getName())
                .speciality(doctor.getSpeciality().toString())
                .patientName(patient.getName())
                .city(doctor.getCity().toString())
                .symptom(patient.getSymptom().toString())
                .build();

        return doctorSuggestDto;
    }
}
