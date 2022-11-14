package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.repository.ClienteRepository;
import com.wassabi.wassabiapp.service.ClienteService;

@RestController
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository repository;

    @Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

    @GetMapping("/cliente")
    public @ResponseBody Iterable<Cliente> getCliente(){
        return repository.findAll();
    }

    @GetMapping("cliente/{cliente_id}")
    public Cliente getCliente(@PathVariable int cliente_id){
        Cliente cliente = repository.findById(cliente_id).get();
        return cliente;
    }

    @PostMapping("/cliente")
    public void createCliente(@RequestBody Cliente cliente){
        System.out.println(cliente);
        this.clienteService.createCliente(cliente);
    }
    
}
