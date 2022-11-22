package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Usuario;
import com.wassabi.wassabiapp.repository.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteService clienteService;

    @Transactional
    public Usuario saveUsuario(Usuario usuario){
        usuario = usuarioRepository.save(usuario);
        if (usuario.getCliente() != null) {
            clienteService.saveCliente(usuario.getCliente());
        }
        return usuario;
    }

    @Transactional
    public Iterable<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario getUsuario(int usuario_id){
        return usuarioRepository.findById(usuario_id).get();
    }

    @Transactional
    public Usuario getUsuariobyEmail(String usuarioEmail){
        return usuarioRepository.findByUsuarioEmail(usuarioEmail);
    }

    @Transactional
    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
