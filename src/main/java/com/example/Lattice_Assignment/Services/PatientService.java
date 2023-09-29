package com.example.Lattice_Assignment.Services;

import com.example.Lattice_Assignment.DTOs.RequestDtos.PatientEntryDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorResponseDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorSuggestDto;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.PatientResponseDto;
import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.example.Lattice_Assignment.Enums.Speciality;
import com.example.Lattice_Assignment.Enums.Symptoms;
import com.example.Lattice_Assignment.Exception.PatientNotFoundException;
import com.example.Lattice_Assignment.Models.Doctor;
import com.example.Lattice_Assignment.Models.Patient;
import com.example.Lattice_Assignment.Repository.DoctorRepository;
import com.example.Lattice_Assignment.Repository.PatientRepository;
import com.example.Lattice_Assignment.Transformers.DoctorTransformer;
import com.example.Lattice_Assignment.Transformers.PatientTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public PatientResponseDto addPatient(PatientEntryDto patientEntryDto) {
        Patient patient = PatientTransformer.convertEntryDtoToEntity(patientEntryDto);
        patientRepository.save(patient);
        return PatientTransformer.covertEntityToDto(patient);
    }

    public List<DoctorSuggestDto> suggestDoctors(int patientId) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if(patientOptional.isEmpty()) throw new PatientNotFoundException("Patient not found, Invalid patient ID!!");

        Patient patient = patientOptional.get();
        Symptoms patientSymptom = patient.getSymptom();

        Speciality requriedSpeciality = Speciality.valueOf(patientSymptom.speciality);
        String requiredCity = patient.getCity().toUpperCase();

        DoctorCity isCity;
        try {
            isCity = DoctorCity.valueOf(requiredCity);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("We are still waiting to expand to your location");
        }

        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorSuggestDto> doctorSuggestDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList){
            if((doctor.getCity().toString().equals(requiredCity)) && doctor.getSpeciality().equals((requriedSpeciality))){
                DoctorSuggestDto doctorSuggestDto = DoctorTransformer.convertEntityToDto(doctor,patient);
                doctorSuggestDto.setStatusCode("200");
                doctorSuggestDto.setStatusMessage("Doctor Available!!");
                doctorSuggestDtoList.add(doctorSuggestDto);
            }
        }

        if(doctorSuggestDtoList.size() == 0){
            throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
        }

        return doctorSuggestDtoList;
    }

    public String removePatient(int patientId) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if(patientOptional.isEmpty()) throw new PatientNotFoundException("Patient not found, Invalid patient ID!!");
        patientRepository.deleteById(patientId);

        return "Patient removed successfully";

    }
}
