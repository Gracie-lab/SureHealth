package com.hospital.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private String email;
    private String phone_number;
    private LocalDateTime booked_on;
    private LocalDateTime proposed_appointment_date;
    private String purpose_of_appointment;
}
