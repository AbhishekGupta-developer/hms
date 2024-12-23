package com.apollo.hms.repository;

import com.apollo.hms.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PatientRepository {

    // Dummy database
    public Map<Long, Patient> doctors = new HashMap<>();

    // dummy doctor ID generator
    public Long id = 0L;
}
