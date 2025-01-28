package com.apollo.hms.dto;

import com.apollo.hms.enums.City;
import com.apollo.hms.enums.Gender;
import com.apollo.hms.enums.Speciality;
import lombok.Data;

@Data
public class DoctorInputDto {
    private String name;
    private City city;
    private String email;
    private String phone;
    private Speciality speciality;
    private Gender gender;
}
