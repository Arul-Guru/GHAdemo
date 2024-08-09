package com.userproject.crud.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v2/users")
public class UserViewController {

    @GetMapping
    public String getUsers(){

        return "usersview";
    }
}
