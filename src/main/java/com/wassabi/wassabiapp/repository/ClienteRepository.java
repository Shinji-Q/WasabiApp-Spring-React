package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;


import com.wassabi.wassabiapp.model.Cliente;

/*
 * Cliente Repository
 */
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    
}
