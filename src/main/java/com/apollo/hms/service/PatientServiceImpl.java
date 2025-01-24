package com.apollo.hms.service;

import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;
import com.apollo.hms.model.Patient;
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

        Patient patient = patientRepository.findById(id).orElse(null);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public List<PatientOutputDto> getAllPatients() {
        List<PatientOutputDto> patientOutputDtoList = new ArrayList<>();

        List<Patient> patients = patientRepository.findAll();

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
        Patient patient = new Patient();

        patient.setName(patientInputDto.getName());
        patient.setSymptom(patientInputDto.getSymptom());
        patient.setGender(patientInputDto.getGender());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

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

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();
        patientRepository.deleteById(id);

        return "Patient name: " + name + "Patient id: " + id + ", removed successfully!";
    }
}
