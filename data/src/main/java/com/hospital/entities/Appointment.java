package com.hospital.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
public class Appointment {

    @Id
    private Integer id;

    private Integer user_id;

    private String phone_number;
    private LocalDateTime booked_on;
    private LocalDateTime proposed_appointment_date;
    private String purpose_of_appointment;
    private String appointmentNumber;
}
