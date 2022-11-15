package com.wassabi.wassabiapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.repository.EnderecoRepository;

@Service("EnderecoService")
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco createEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }   
}
