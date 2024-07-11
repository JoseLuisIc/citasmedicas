package com.consultorio.citasmedicas.services;

import com.consultorio.citasmedicas.model.Appointment;
import com.consultorio.citasmedicas.model.Doctor;
import com.consultorio.citasmedicas.respositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void saveAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Optional<Appointment> findById(Long id){
        return appointmentRepository.findById(id);
    }

}
