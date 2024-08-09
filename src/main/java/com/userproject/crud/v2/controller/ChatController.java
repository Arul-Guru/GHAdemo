package com.userproject.crud.v2.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chatPage")
    public String getChatPage(){
        return "chat";
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String sendMessage(String message){
        return message;
    }
}
