package com.apollo.hms.service;

import com.apollo.hms.dto.DoctorInputDto;
import com.apollo.hms.dto.DoctorOutputDto;

import java.util.List;

public interface DoctorService {
    DoctorOutputDto getDoctor(Long id);
    List<DoctorOutputDto> getAllDoctors();
    DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto);
    DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto);
    String removeDoctor(Long id);
}
