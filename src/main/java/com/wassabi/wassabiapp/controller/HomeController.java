package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.security.CustomUserDetails;
import com.wassabi.wassabiapp.service.UsuarioService;

@RestController
public class HomeController {
    
    @Autowired
    UsuarioService usuarioService;

    // @Autowired
    // CustomUserDetails customUserDetails;

    @GetMapping("/")
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        return (customUserDetails.getUsername());
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
