package com.hospital.services;

import com.hospital.dtos.*;
import com.hospital.entities.Appointment;
import com.hospital.exceptions.AppException;

public interface UserService {
    public AddUserResponse addUser(AddUserDto request);
    public GeneralResponse removeUser(RemoveUserRequest request);
    public AppointmentResponse makeAppointment(AppointmentRequest request) throws AppException;
    public GeneralResponse removeAppointment(RemoveAppointmentRequest request) throws AppException;
}
