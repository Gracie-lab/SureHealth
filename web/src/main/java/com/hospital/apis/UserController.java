package com.hospital.apis;

import com.hospital.dtos.AddUserDto;
import com.hospital.dtos.RemoveUserRequest;
import com.hospital.exceptions.AppException;
import com.hospital.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<?> registerDoctor(@RequestBody AddUserDto request) throws AppException{
        var response = userService.addUsers(request);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> removeUser(@RequestBody RemoveUserRequest request){
        var response = userService.removeUser(request);
        return ResponseEntity.ok(response);
    }
}
