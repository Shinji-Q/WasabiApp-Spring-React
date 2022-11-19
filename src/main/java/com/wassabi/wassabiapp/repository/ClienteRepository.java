package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Cliente;

/*
 * Cliente Repository
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>, CustomClienteRepository {
    
}
