package com.hospital.services;

import com.hospital.entities.User;
import com.hospital.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    UserRepository userRepository;

    @Mock
    UserService userService;

    @Test
    @DisplayName("Test that user is saved when created")
    public void TestAddUser(){
        com.hospital.dtos.AddUserDto dto = new com.hospital.dtos.AddUserDto();
        when(userRepository.save(new User())).thenReturn(new User());
        userService.addUser(dto);

        verify(userRepository, times(1)).save(new User());
    }

}