package com.hospital.services;

import com.hospital.dtos.*;
import com.hospital.entities.Appointment;
import com.hospital.entities.User;
import com.hospital.exceptions.AppException;
import com.hospital.repositories.AppointmentRepository;
import com.hospital.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    static ModelMapper modelMapper = new ModelMapper();
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddUserMapper mapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public AddUserResponse addUser(com.hospital.dtos.AddUserDto request) {
        var user = modelMapper.map(request, User.class);
        userRepository.save((user));
        return modelMapper.map(request, AddUserResponse.class);
    }

    private GeneralResponse find(String email){
        GeneralResponse response = new GeneralResponse();
       if(userRepository.findByEmail(email) != null){
           response.setMessage("A user with this email already exists");
       }
       return  response;
    }

    @Override
    public User addUsers(com.hospital.dtos.AddUserDto request) throws AppException {
        var userExists = userRepository.findByEmail(request.getEmail());
       // find(request.getEmail());
        if(userExists != null) throw new AppException("A user with this email already exists");
        var user = mapper.createUserFrom(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save((user));
        return user;
    }

    @Override
    public GeneralResponse removeUser(RemoveUserRequest request) {
        var user =userRepository.findByEmail(request.getEmail());
        userRepository.delete(user);
        var response = new GeneralResponse();
        response.setMessage("User deleted successfully");
        return response;

    }

    @Override
    public Appointment makeAppointment(AppointmentRequest request) throws AppException {
        var user = userRepository.findByEmail(request.getEmail());
        if(user == null) throw new AppException("Sorry, this email is not registered with us.");
        var appointment = mapper.createAppointmentFrom(request);
        appointmentRepository.save(appointment);
        appointment.setAppointmentNumber("SHA" + appointment.getId());
        appointment.setBooked_on(LocalDateTime.now());
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public GeneralResponse removeAppointment(RemoveAppointmentRequest request) throws AppException {
        var appointment = appointmentRepository.findByAppointmentNumber(request.getAppointment_number());
        if(appointment == null) throw new AppException("Appointment does not exist. Check appointment number");
        appointmentRepository.delete(appointment);
        var response = new GeneralResponse();
        response.setMessage("Appointment removed");
        return response;
    }
}
