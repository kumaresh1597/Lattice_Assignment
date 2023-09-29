package com.example.Lattice_Assignment.Models;

import com.example.Lattice_Assignment.Enums.DoctorCity;
import com.example.Lattice_Assignment.Enums.Speciality;
import com.example.Lattice_Assignment.Enums.Symptoms;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "patient")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int patientId;

    private String name;

    private String city;

    private String email;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Symptoms symptom;

}
