package com.hospital.dtos;

import com.hospital.entities.Appointment;
import com.hospital.entities.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class AddUserMapper {
    public User createUserFrom(AddUserDto dto){
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setPhone_number(dto.getPhone_number());
        user.setLast_name(dto.getLast_name());
        user.setFirst_name(dto.getFirst_name());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        return user;

    }

    public Appointment createAppointmentFrom(AppointmentRequest request){
        Appointment appointment = new Appointment();
        appointment.setBooked_on(LocalDateTime.now());
        appointment.setPhone_number(request.getPhone_number());
        appointment.setPurpose_of_appointment(request.getPurpose_of_appointment());
        appointment.setProposed_appointment_date(request.getProposed_appointment_date());
        return  appointment;
    }
}
