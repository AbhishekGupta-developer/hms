package com.apollo.hms.service;

import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;

import java.util.List;

public interface PatientService {
    public PatientOutputDto getPatient(Long id);
    public List<PatientOutputDto> getAllPatients();
    public PatientOutputDto addPatient(PatientInputDto patientInputDto);
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto);
    public String removePatient(Long id);
}
