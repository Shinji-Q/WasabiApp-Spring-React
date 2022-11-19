package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.EnderecoId;
import com.wassabi.wassabiapp.repository.EnderecoRepository;

@Service("EnderecoService")
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public Iterable<Endereco> getAllEndereco(){
        return enderecoRepository.findAll();
    }

    @Transactional
    public Endereco getEndereco(EnderecoId endereco_id){
        return enderecoRepository.findById(endereco_id).get();
    }

    @Transactional
    public void deleteEndereco(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }
}
