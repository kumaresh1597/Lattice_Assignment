package com.example.Lattice_Assignment.Enums;

import static com.example.Lattice_Assignment.Enums.Speciality.Dermatology;

public enum Symptoms {
    ARTHRITIS("Orthopedic"),
    BACKPAIN("Orthopedic"),
    TISSUEINJURIES("Orthopedic"),
    DYSMENORRHEA("Gynecology"),
    SKININFECTION("Dermatology"),
    SKINBURN("Dermatology"),
    EARPAIN("ENT");

    public final String speciality;

    private Symptoms(String speciality) {
        this.speciality = speciality;
    }
}
