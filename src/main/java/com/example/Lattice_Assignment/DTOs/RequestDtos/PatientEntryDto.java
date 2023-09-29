package com.example.Lattice_Assignment.DTOs.RequestDtos;

import com.example.Lattice_Assignment.Enums.Symptoms;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PatientEntryDto {

    @Size(min = 3,message = "Name should be minimum 3 characters!!")
    private String name;

    @Size(max=20,message = "Minimum 20 characters!!")
    private String city;

    @Email(message = "Enter valid Email Id !!")
    private String email;

    @Size(min = 10,message = "Invalid!!, Enter atleast 10 numbers!!")
    private String mobile;

    private String symptom;
}
