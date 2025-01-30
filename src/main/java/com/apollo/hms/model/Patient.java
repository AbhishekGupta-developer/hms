package com.apollo.hms.model;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Symptom;
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

    private String city;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Bill bill;
}
