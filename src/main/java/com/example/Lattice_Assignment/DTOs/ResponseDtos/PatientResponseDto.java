package com.example.Lattice_Assignment.DTOs.ResponseDtos;

import com.example.Lattice_Assignment.Enums.Symptoms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {

    private String name;
    private String city;
    private String email;
    private String mobile;
    private Symptoms symptom;
}
