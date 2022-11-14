package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.repository.ClienteRepository;

@Service("ClienteService")
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente createCliente(Cliente cliente){
        cliente = repository.save(cliente);
        return cliente;
    }   
}
