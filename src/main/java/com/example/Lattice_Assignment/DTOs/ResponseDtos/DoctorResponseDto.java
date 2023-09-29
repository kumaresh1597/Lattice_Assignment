package com.example.Lattice_Assignment.DTOs.ResponseDtos;

import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.example.Lattice_Assignment.Enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {
    private  String name;
    private DoctorCity city;
    private String email;
    private String mobile;
    private Speciality speciality;
}
