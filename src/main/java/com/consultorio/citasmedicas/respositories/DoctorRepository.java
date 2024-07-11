package com.consultorio.citasmedicas.respositories;

import com.consultorio.citasmedicas.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
