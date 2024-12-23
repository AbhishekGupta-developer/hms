package com.apollo.hms.dto;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Symptoms;
import lombok.Data;

@Data
public class PatientInputDto {
    private String name;
    private Symptoms symptom;
    private Gender gender;
}
