package com.apollo.hms.service;

import com.apollo.hms.dto.DoctorInputDto;
import com.apollo.hms.dto.DoctorOutputDto;
import com.apollo.hms.model.Doctor;
import com.apollo.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorOutputDto getDoctor(Long id) {
        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        Doctor doctor = doctorRepository.findById(id).orElse(null);

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setSpecialisation(doctor.getSpecialisation());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());

        return doctorOutputDto;
    }

    @Override
    public List<DoctorOutputDto> getAllDoctors() {
        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        List<Doctor> doctors = doctorRepository.findAll();

        for(Doctor doctor : doctors) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setSpecialisation(doctor.getSpecialisation());
            doctorOutputDto.setGender(doctor.getGender());
            doctorOutputDto.setSalary(doctor.getSalary());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    @Override
    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorInputDto.getName());
        doctor.setSpecialisation(doctorInputDto.getSpecialisation());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setSalary(doctorInputDto.getSalary());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setSpecialisation(doctor.getSpecialisation());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());

        return doctorOutputDto;
    }

    @Override
    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setId(id);
        doctor.setName(doctorInputDto.getName());
        doctor.setSpecialisation(doctorInputDto.getSpecialisation());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setSalary(doctorInputDto.getSalary());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setSpecialisation(doctor.getSpecialisation());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setSalary(doctor.getSalary());

        return doctorOutputDto;
    }

    @Override
    public String removeDoctor(Long id) {
        String name = doctorRepository.findById(id).orElse(null).getName();
        doctorRepository.deleteById(id);

        return "Doctor name: " + name + "Doctor id: " + id + ", removed successfully!";
    }
}
