package com.wassabi.wassabiapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.Endereco;

/**
 * ClienteRepositoryTest
 */
@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    ClienteRepository repository;

    @Autowired
    EnderecoRepository repository2;

    @Test
    public void createCliente(){

        Cliente cliente = new Cliente("null", "null", "null", "null");
        //Cliente cliente = repository.findById(2).get();

        Endereco endereco = new Endereco(cliente, "nuasdsadall", "null", "null", "null", "null", "null");

        cliente.addEndereco(endereco);
        repository.save(cliente);
    }
    
}