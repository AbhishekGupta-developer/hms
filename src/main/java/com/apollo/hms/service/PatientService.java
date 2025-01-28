package com.apollo.hms.service;

import com.apollo.hms.dto.DoctorOutputDto;
import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;

import java.util.List;

public interface PatientService {
    PatientOutputDto getPatient(Long id);
    List<PatientOutputDto> getAllPatients();
    PatientOutputDto addPatient(PatientInputDto patientInputDto);
    PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto);
    String removePatient(Long id);
    List<DoctorOutputDto> suggestDoctors(Long id);
}
