package com.userproject.crud.user;

import com.userproject.crud.dao.UserRepository;
import com.userproject.crud.models.User;
import com.userproject.crud.services.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    public UserTest(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUsername("Arul");
        user.setEmail("arul@123.com");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User createdUser = userService.addUser(user);

        assertNotNull(createdUser);
        assertEquals("Arul",createdUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }

//


}
