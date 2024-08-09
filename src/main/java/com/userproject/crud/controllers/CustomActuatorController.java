package com.userproject.crud.controllers;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="healthcheck")
public class CustomActuatorController {

    @ReadOperation
    public String customActuator(){
        return "Custom actuator response";
    }
}
