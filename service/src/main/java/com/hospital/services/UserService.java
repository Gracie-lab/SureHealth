package com.hospital.services;

import com.hospital.dtos.*;
import com.hospital.entities.Appointment;
import com.hospital.entities.User;
import com.hospital.exceptions.AppException;

public interface UserService {
    public AddUserResponse addUser(AddUserDto request);
    public GeneralResponse removeUser(RemoveUserRequest request);
    public Appointment makeAppointment(AppointmentRequest request) throws AppException;
    public GeneralResponse removeAppointment(RemoveAppointmentRequest request) throws AppException;
    public User addUsers(AddUserDto request) throws AppException;

}
