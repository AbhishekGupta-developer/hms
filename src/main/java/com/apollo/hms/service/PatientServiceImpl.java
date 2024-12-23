package com.apollo.hms.service;

import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Override
    public PatientOutputDto getPatient(Long id) {
        return null;
    }

    @Override
    public List<PatientOutputDto> getAllPatients() {
        return List.of();
    }

    @Override
    public PatientOutputDto addPatient(PatientInputDto patientInputDto) {
        return null;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        return null;
    }

    @Override
    public String removePatient(Long id) {
        return "";
    }
}
