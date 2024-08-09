package com.userproject.crud.controllers;

import com.userproject.crud.exceptions.UserNotFoundException;
import com.userproject.crud.models.User;
import com.userproject.crud.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(HttpServletRequest request){


    return new ResponseEntity<>( service.getAllUsers(), HttpStatus.OK);


    }


//    @PostMapping
//    public ResponseEntity<User> createUser(HttpServletRequest request){
////        request.getReader().read(
//        return new ResponseEntity<>(service.addUser(user),HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)throws UserNotFoundException{
       return new ResponseEntity<User>(service.getUserById(id),HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<User>(service.updateUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id)throws UserNotFoundException {
        return new ResponseEntity<User>(service.deleteUser(id),HttpStatus.OK);
    }

    @GetMapping("/passwords")
    public ResponseEntity<List<User>> getUserByPassword(@RequestParam String password){
        return new ResponseEntity<List<User>>(service.getUserByPassword(password),HttpStatus.OK);
    }



}
