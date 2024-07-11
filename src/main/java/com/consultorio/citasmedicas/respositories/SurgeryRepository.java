package com.consultorio.citasmedicas.respositories;

import com.consultorio.citasmedicas.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
