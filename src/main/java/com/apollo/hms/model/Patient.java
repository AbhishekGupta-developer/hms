package com.apollo.hms.model;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Symptoms;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Symptoms symptom;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
