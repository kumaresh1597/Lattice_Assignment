package com.example.Lattice_Assignment.Repository;

import com.example.Lattice_Assignment.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
