package com.hospital.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void registerHospitalApiTest() throws Exception {
        User user = new User();
        user.setEmail("grace@yahoo.com");
        user.setAddress("some address");
        user.setFirst_name("firstname");
        user.setLast_name("lastname");
        user.setPhone_number("08076854673");
        user.setPassword("mypassword");

        ObjectMapper mapper = new ObjectMapper();

        this.mockMvc.perform(post("/user/add-user")
                .contentType("application/json")
                .content(mapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}