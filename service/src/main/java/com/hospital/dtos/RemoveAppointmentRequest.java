package com.hospital.dtos;

import lombok.Data;

@Data
public class RemoveAppointmentRequest {
    private String appointment_number;
    private String email;
}
