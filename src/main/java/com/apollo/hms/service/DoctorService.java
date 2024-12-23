package com.apollo.hms.service;

import com.apollo.hms.dto.DoctorInputDto;
import com.apollo.hms.dto.DoctorOutputDto;

import java.util.List;

public interface DoctorService {
    public DoctorOutputDto getDoctor(Long id);
    public List<DoctorOutputDto> getAllDoctors();
    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto);
    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto);
    public String removeDoctor(Long id);
}
