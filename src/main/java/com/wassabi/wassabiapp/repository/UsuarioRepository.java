package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.wassabi.wassabiapp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
