package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
