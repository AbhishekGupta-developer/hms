package com.apollo.hms.entity;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Specialisation;
import lombok.Data;

@Data
public class Doctor {
    private Long id;
    private String name;
    private Specialisation specialisation;
    private Gender gender;
    private Long salary;

}
