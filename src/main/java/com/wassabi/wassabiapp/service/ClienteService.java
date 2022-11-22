package com.wassabi.wassabiapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.repository.ClienteRepository;

@Service("ClienteService")
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CartaoService cartaoService;

    @Transactional
    public Cliente saveCliente(Cliente cliente){
        Set<Endereco> enderecos = cliente.getEnderecos();
        Set<Cartao> cartoes = cliente.getCartaos();
        boolean aEndereco = false;
        boolean aCartao = false;
        if (enderecos.size() > 0) {
            aEndereco = true;
            cliente.setEnderecos(new HashSet<>(0));
        }
        if (cartoes.size() > 0) {
            aCartao = true;
            cliente.setCartaos(new HashSet<>(0));
        }
        cliente = clienteRepository.save(cliente);
        cliente.addEndereco(enderecos);
        cliente.updateEnderecoID();
        cliente.addCartao(cartoes);
        cliente.updateCartaoID();
        if (aEndereco) {
            saveEnderecos(enderecos);
            cliente.addEndereco(enderecos);
        }
        if (aCartao) {
            saveCartoes(cartoes);
            cliente.addCartao(cartoes);
        }        
        return cliente;
    }

    @Transactional
    private void saveCartoes(Set<Cartao> cartoes) {
        for (Cartao cartao : cartoes) {
            cartaoService.saveCartao(cartao);
        }
    }

    @Transactional
    private void saveEnderecos(Set<Endereco> enderecos){
        for (Endereco endereco : enderecos) {
            enderecoService.saveEndereco(endereco);
        }
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
