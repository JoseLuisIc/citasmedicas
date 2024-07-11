package com.consultorio.citasmedicas.respositories;

import com.consultorio.citasmedicas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
