package com.wassabi.wassabiapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuarioEmail(email);
        if (usuario == null){
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(usuario);
    }
    
}
