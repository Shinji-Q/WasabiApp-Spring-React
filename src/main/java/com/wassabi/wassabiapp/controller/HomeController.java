package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.service.UsuarioService;

@RestController
public class HomeController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String home(){
        return "This is Home Page";
    }

    @GetMapping("/user")
    public String user(){
        return "This is User Page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }

}
