package com.example.Lattice_Assignment.Models;

import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.example.Lattice_Assignment.Enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int doctorId;

    private String name;

    @Enumerated(EnumType.STRING)
    private DoctorCity city;

    private String email;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

}
