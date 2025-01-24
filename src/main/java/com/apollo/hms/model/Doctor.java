package com.apollo.hms.model;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Specialisation;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Specialisation specialisation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long salary;

}
