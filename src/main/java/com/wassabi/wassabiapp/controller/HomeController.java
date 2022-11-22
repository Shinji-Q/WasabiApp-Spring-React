package com.wassabi.wassabiapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.repository.UsuarioRepository;
import com.wassabi.wassabiapp.security.CustomUserDetails;
import com.wassabi.wassabiapp.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:80")
@RestController
public class HomeController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Usuario getLoggedUser() throws UsernameNotFoundException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        String loggedUserUsername = customUserDetails.getUsername();
        Usuario loggedUser = usuarioRepository.findByUsuarioEmail(loggedUserUsername);
        if (loggedUser == null){
            throw new UsernameNotFoundException(loggedUserUsername);
        }
        return loggedUser;
    }

    @GetMapping("/loggedUserCliente")
    public Cliente getLoggedUserCliente(){
        
        Cliente loggedUserCliente = getLoggedUser().getCliente();
        
        return loggedUserCliente;
    }

    @GetMapping("/loggedUserCartao")
    public Iterable<?> getLoggedUsercartao(){
        Cliente loggedUserCliente = getLoggedUser().getCliente();
        Set<Cartao> loggedUserCartao = loggedUserCliente.getCartaos();
        
        return  loggedUserCartao;
    }

    @GetMapping("/loggedUserEndereco")
    public Iterable<?> getLoggedUserEndereco(){
        Cliente loggedUserCliente = getLoggedUser().getCliente();
        Set<Endereco> loggedUserEndereco = loggedUserCliente.getEnderecos();
        
        return loggedUserEndereco;
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
