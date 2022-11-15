package com.wassabi.wassabiapp.repository;

import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Cliente;
import com.wassabi.wassabiapp.model.EnderecoId;

/**
* Interface para realizar o cadastro do Cliente.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/



public class CustomClienteRepositoryImpl implements CustomClienteRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private EnderecoRepository enderecoRepository;

      
    /** 
     * Função responsavel por armazenar os clientes no banco de dados.
     * @param cliente - Recebe um objeto cliente a fim de torna-lo permanente.
     */
    @Override
    @Transactional
    public Cliente createCliente(Cliente cliente){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        
        entityManager.persist(cliente);
        //cliente.updateEnderecoID();
        cliente.updateCartaoID();
        cliente.getEnderecos().forEach(e -> {
            System.out.println(cliente);
            e.setCliente(cliente);
            e.setId(new EnderecoId());
            //e.getId().setEnderecoId(null);
            e.getId().setEnderecoCliente(cliente.getClienteId());
            enderecoRepository.save(e);
        });
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Cliente cadastrado com sucesso");
        return cliente;
    }

    //@PostConstruct
    //public void postConstruct() {
    //    Objects.requireNonNull(entityManager);
    //}
}