package com.apollo.hms.service;

import com.apollo.hms.dto.DoctorOutputDto;
import com.apollo.hms.dto.PatientInputDto;
import com.apollo.hms.dto.PatientOutputDto;
import com.apollo.hms.enums.City;
import com.apollo.hms.enums.Speciality;
import com.apollo.hms.enums.Symptom;
import com.apollo.hms.model.Bill;
import com.apollo.hms.model.Doctor;
import com.apollo.hms.model.Patient;
import com.apollo.hms.repository.DoctorRepository;
import com.apollo.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public PatientOutputDto getPatient(Long id) {
        PatientOutputDto patientOutputDto = new PatientOutputDto();

        Patient patient = patientRepository.findById(id).orElse(null);

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
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
            patientOutputDto.setCity(patient.getCity());
            patientOutputDto.setEmail(patient.getEmail());
            patientOutputDto.setPhone(patient.getPhone());
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
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptom(patientInputDto.getSymptom());
        patient.setGender(patientInputDto.getGender());

        Bill bill = new Bill();
        bill.setAmount(1000D);
        bill.setPatient(patient);

        patient.setBill(bill);

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());
        patientOutputDto.setBill(patient.getBill());

        return patientOutputDto;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setId(id);
        patient.setName(patientInputDto.getName());
        patient.setCity(patientInputDto.getCity());
        patient.setEmail(patientInputDto.getEmail());
        patient.setPhone(patientInputDto.getPhone());
        patient.setSymptom(patientInputDto.getSymptom());
        patient.setGender(patientInputDto.getGender());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setCity(patient.getCity());
        patientOutputDto.setEmail(patient.getEmail());
        patientOutputDto.setPhone(patient.getPhone());
        patientOutputDto.setSymptom(patient.getSymptom());
        patientOutputDto.setGender(patient.getGender());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();
        patientRepository.deleteById(id);

        return "Patient name: " + name + " (" + id + "), removed successfully!";
    }

    @Override
    public List<DoctorOutputDto> suggestDoctors(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);

        City patientCity = City.valueOf(patient.getCity().toUpperCase());

        Speciality neededSpeciality = getSpeciality(patient.getSymptom());

        List<Doctor> doctorList = doctorRepository.findByCityAndSpeciality(patientCity, neededSpeciality);

        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setCity(doctor.getCity());
            doctorOutputDto.setEmail(doctor.getEmail());
            doctorOutputDto.setPhone(doctor.getPhone());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());
            doctorOutputDto.setGender(doctor.getGender());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    public Speciality getSpeciality(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPEDIC;
            case DYSMENORRHEA -> Speciality.GYNAECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
        };
    }
}
