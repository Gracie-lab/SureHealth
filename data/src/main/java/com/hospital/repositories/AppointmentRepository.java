package com.hospital.repositories;

import com.hospital.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    public Appointment findByAppointmentNumber(String appointmentNumber);

}
