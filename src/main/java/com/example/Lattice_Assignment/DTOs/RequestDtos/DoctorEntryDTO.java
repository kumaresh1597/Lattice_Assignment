package com.example.Lattice_Assignment.DTOs.RequestDtos;

import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.example.Lattice_Assignment.Enums.Speciality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DoctorEntryDTO {

    @Size(min = 3,message = "Name should be minimum 3 characters!!")
    private String name;

    private DoctorCity city;

    @Email(message = "Enter valid Email Id !!")
    private String email;

    @Size(min = 10,message = ("Invalid!!, Enter atleast 10 numbers!!"))
    private String mobile;

    private Speciality speciality;

}
