package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer>{
    
}
