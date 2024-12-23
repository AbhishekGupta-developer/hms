package com.apollo.hms.entity;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Symptoms;
import lombok.Data;

@Data
public class Patient {
    private Long id;
    private String name;
    private Symptoms symptom;
    private Gender gender;
}
