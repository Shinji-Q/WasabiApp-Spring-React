package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Cliente;

/**
* Interface para realizar o cadastro do Cliente.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class ClienteDAO {

    private ClienteDAO(){}
      
    /** 
     * Função responsavel por armazenar os clientes no banco de dados.
     * @param cliente - Recebe um objeto cliente a fim de torna-lo permanente.
     */
    public static void createCliente(Cliente cliente){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(cliente);
        cliente.updateEnderecoID();
        cliente.updateCartaoID();
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Cliente cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos clientes no banco de dados.
     * @param cliente - Recebe um objeto Cliente com ID e os dados a serem atualizados.
     */
    public static void updateCliente(Cliente cliente){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(cliente);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Cliente atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os clientes no banco de dados.
     * @param cliente - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteCliente(int cliente_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        Cliente cliente = entityManager.find(Cliente.class, cliente_id);
        entityManager.remove(cliente);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Cliente deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado cliente no banco de dados.
     * @param cliente_id - Chave primaria do objeto cliente.
     * @return Cliente - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Cliente findCliente_byID(int cliente_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Cliente cliente = entityManager.find(Cliente.class, cliente_id);
        
        entityManager.close();

        if (cliente != null){
            System.out.println("Cliente encontrado");
            return cliente;
        } else {
            System.out.println("Cliente não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos clientes presentes no banco de dados.
     * @return List<Cliente> - retorna uma lista com até 10 clientes.
     */
    public static List<Cliente> readClientes(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Cliente> clienteQuery = entityManager.createQuery("from Cliente", Cliente.class);
        List<Cliente> clientes = clienteQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (clientes.size() > 0){
            System.out.println("Clientes encontrados");
            return clientes;
        } else {
            System.out.println("Não foram encontrados cliente no banco de dados");
            return clientes;
        }
    }
}
