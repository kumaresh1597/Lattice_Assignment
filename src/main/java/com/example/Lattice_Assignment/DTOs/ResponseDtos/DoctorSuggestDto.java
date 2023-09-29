package com.example.Lattice_Assignment.DTOs.ResponseDtos;

import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"statusCode","statusMessage","doctorName","speciality","patientName","symptom","city"})
public class DoctorSuggestDto {

    private String statusCode;
    private String statusMessage;

    private String doctorName;
    private String speciality;
    private String patientName;
    private String symptom;
    private String city;

}
