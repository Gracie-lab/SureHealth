package com.hospital.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private Integer id;

    private String first_name;
    private String last_name;
    private String email; //email is username
    private String phone_number;
    private String address;
    private String password;
    @Enumerated(EnumType.STRING)
    private  Gender gender;



}
