package com.userproject.crud.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userproject.crud.controllers.UserController;
import com.userproject.crud.models.User;
import com.userproject.crud.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> users;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("Arul");

        users.add(user1);
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("Mark");
        users.add(user2);

    }


    @Test
    public void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].username").value("Arul" ));
    }


//    @Test
//    public void testGetUserById() throws Exception {
//        when(userService.getUserById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
//
//        mockMvc.perform(get("/api/users/1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("username").value("Arul"));
//    }


//    @Test
//    public void testCreateUser() throws Exception {
//        mockMvc.perform(post("/api/users")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"username\":\"arul\",\"email\":\"arul@123.com\"}")).
//                andExpect(status().isCreated());
//    }



}
