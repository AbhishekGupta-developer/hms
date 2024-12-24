package com.apollo.hms.service;

import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;
import com.apollo.hms.entity.Patient;
import com.apollo.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public PatientOutputDto getPatient(Long id) {
        PatientOutputDto patientOutputDto = new PatientOutputDto();

        Patient patient = patientRepository.patients.get(id);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public List<PatientOutputDto> getAllPatients() {
        List<PatientOutputDto> patientOutputDtoList = new ArrayList<>();

        List<Patient> patients = new ArrayList<>(patientRepository.patients.values());

        for(Patient patient : patients) {
            PatientOutputDto patientOutputDto = new PatientOutputDto();

            patientOutputDto.setId(patient.getId());
            patientOutputDto.setName(patient.getName());
            patientOutputDto.setSymptom(patient.getSymptom());
            patientOutputDto.setGender(patient.getGender());

            patientOutputDtoList.add(patientOutputDto);
        }

        return patientOutputDtoList;
    }

    @Override
    public PatientOutputDto addPatient(PatientInputDto patientInputDto) {
        Long id = ++patientRepository.id;

        Patient patient = new Patient();

        patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setSymptom(patientInputDto.getSymptom());
        patient.setGender(patientInputDto.getGender());

        patientRepository.patients.put(id, patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patient = patientRepository.patients.get(id);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setSymptom(patientInputDto.getSymptom());
        patient.setGender(patientInputDto.getGender());

        patientRepository.patients.put(id, patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patient = patientRepository.patients.get(id);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        patientRepository.patients.remove(id);

        return "Patient id: " + id + ", removed successfully!";
    }
}
