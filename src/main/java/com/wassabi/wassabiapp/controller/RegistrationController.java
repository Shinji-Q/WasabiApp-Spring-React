package com.wassabi.wassabiapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wassabi.wassabiapp.security.UserData;

@Controller
public class RegistrationController {
    
    @GetMapping("/register")
    public String register(final Model model) {
        model.addAttribute("userData",new UserData());

        return "/register";
    }

    @PostMapping
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("userData", userData);
            return "/register";
        }
        
        return "account/starter";
    }

}
