package com.hospital.dtos;

import java.time.LocalDateTime;

public class AppointmentResponse {
    private String email;
    private String phone_number;
    private LocalDateTime booked_on;
    private LocalDateTime proposed_appointment_date;
    private String purpose_of_appointment;
}
