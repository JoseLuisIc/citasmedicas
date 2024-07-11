package com.consultorio.citasmedicas.services;


import com.consultorio.citasmedicas.model.Doctor;
import com.consultorio.citasmedicas.model.Surgery;
import com.consultorio.citasmedicas.respositories.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    public List<Surgery> getAllSurgerys(){
        return surgeryRepository.findAll();
    }
}
