package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.repository.EnderecoRepository;
import com.wassabi.wassabiapp.service.EnderecoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EnderecoController {

    private EnderecoService enderecoService;

    @Autowired
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
    
    @Autowired
    private EnderecoRepository repository;

    @GetMapping("/endereco")
    public Iterable<Endereco> getAllEndereco(){
        return repository.findAll();
    }

    @PostMapping(value="/endereco")
    public Endereco postMethodName(@RequestBody Endereco endereco) {
        endereco = enderecoService.createEndereco(endereco);
        return endereco;
    }
    
}
