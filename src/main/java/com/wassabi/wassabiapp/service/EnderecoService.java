package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.repository.EnderecoRepository;

@Service("EnderecoService")
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;

    @Transactional
    public Endereco createEndereco(Endereco endereco){
        endereco = repository.save(endereco);
        return endereco;
    }   
}
