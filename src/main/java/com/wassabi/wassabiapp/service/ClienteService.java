package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.repository.ClienteRepository;

@Service("ClienteService")
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente){
        cliente = clienteRepository.save(cliente);
        return cliente;
    }

    @Transactional
    public Iterable<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente getCliente(int cliente_id){
        return clienteRepository.findById(cliente_id).get();
    }

    @Transactional
    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
