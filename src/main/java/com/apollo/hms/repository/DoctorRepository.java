package com.apollo.hms.repository;

import com.apollo.hms.entity.Doctor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DoctorRepository {

    // Dummy database
    public Map<Long, Doctor> doctors = new HashMap<>();

    // dummy doctor ID generator
    public Long id = 0L;
}
