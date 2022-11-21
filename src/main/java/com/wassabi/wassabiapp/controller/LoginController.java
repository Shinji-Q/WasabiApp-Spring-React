package com.wassabi.wassabiapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/login")
public class LoginController {
    
    
    @GetMapping
    public String login(){
        return "Autenticado";
    }

}