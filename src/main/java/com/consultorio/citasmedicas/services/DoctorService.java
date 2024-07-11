package com.consultorio.citasmedicas.services;

import com.consultorio.citasmedicas.model.Doctor;
import com.consultorio.citasmedicas.respositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
}
