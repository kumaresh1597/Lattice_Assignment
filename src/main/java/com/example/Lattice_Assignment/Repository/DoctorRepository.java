package com.example.Lattice_Assignment.Repository;

import com.example.Lattice_Assignment.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
