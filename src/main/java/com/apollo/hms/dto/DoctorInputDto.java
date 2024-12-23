package com.apollo.hms.dto;

import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Specialisation;
import lombok.Data;

@Data
public class DoctorInputDto {
    private String name;
    private Specialisation specialisation;
    private Gender gender;
    private Long salary;
}
