package com.example.Lattice_Assignment.Services;

import com.example.Lattice_Assignment.DTOs.RequestDtos.DoctorEntryDTO;
import com.example.Lattice_Assignment.DTOs.ResponseDtos.DoctorResponseDto;
import com.example.Lattice_Assignment.Exception.DoctorNotFoundException;
import com.example.Lattice_Assignment.Exception.PatientNotFoundException;
import com.example.Lattice_Assignment.Models.Doctor;
import com.example.Lattice_Assignment.Models.Patient;
import com.example.Lattice_Assignment.Repository.DoctorRepository;
import com.example.Lattice_Assignment.Transformers.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public DoctorResponseDto addDoctor(DoctorEntryDTO doctorEntryDTO) {
        Doctor doctor = DoctorTransformer.convertEntryDTOToEntity(doctorEntryDTO);
        doctorRepository.save(doctor);
        return DoctorTransformer.convertEntityToDto(doctor);
    }

    public String removeDoctor(int doctorId) throws DoctorNotFoundException {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if(doctorOptional.isEmpty()) throw new DoctorNotFoundException("Doctor not found, Invalid doctor ID!!");

        doctorRepository.deleteById(doctorId);

        return "Doctor removed Successfully";
    }
}
