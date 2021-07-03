package com.hospital.dtos;

import lombok.Data;

@Data
public class AddUserDto {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;

}
