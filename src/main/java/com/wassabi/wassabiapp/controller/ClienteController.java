package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.security.CustomUserDetails;
import com.wassabi.wassabiapp.service.ClienteService;

@CrossOrigin(origins = "http://localhost:80")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public @ResponseBody Iterable<Cliente> getCliente(){
        return clienteService.getAllCliente();
    }

    @GetMapping("cliente/{cliente_id}")
    public Cliente getCliente(@PathVariable int cliente_id){
        return clienteService.getCliente(cliente_id);
    }

    @PostMapping("/cliente")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        String loggedUserUsername = customUserDetails.getUsername();

        for (Usuario c : cliente.getUsuarios()) {
            if (c.getUsuarioEmail().equals(loggedUserUsername)){
                return clienteService.saveCliente(cliente);
            }
        }
        return null;
    }

    @PutMapping("/cliente")
    public Cliente updateCliente(@RequestBody Cliente cliente){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        String loggedUserUsername = customUserDetails.getUsername();

        for (Usuario c : cliente.getUsuarios()) {
            if (c.getUsuarioEmail().equals(loggedUserUsername)){
                return clienteService.saveCliente(cliente);
            }
        }
        return null;
    }

    @DeleteMapping("/cliente")
    public void deleteCliente(@RequestBody Cliente cliente){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        String loggedUserUsername = customUserDetails.getUsername();

        for (Usuario c : cliente.getUsuarios()) {
            if (c.getUsuarioEmail().equals(loggedUserUsername)){
                clienteService.deleteCliente(cliente);
            }
        }
    }
    
}
