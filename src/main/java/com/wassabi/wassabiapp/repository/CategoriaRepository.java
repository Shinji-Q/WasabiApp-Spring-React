package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
    
}
