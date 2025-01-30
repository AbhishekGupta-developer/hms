package com.apollo.hms.dto;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Symptom;
import com.apollo.hms.model.Bill;
import lombok.Data;

@Data
public class PatientOutputDto {
    private Long id;
    private String name;
    private String city;
    private String email;
    private String phone;
    private Symptom symptom;
    private Gender gender;
    private Bill bill;
}
