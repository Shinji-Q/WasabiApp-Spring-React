package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Cartao;

/**
* Interface para realizar o cadastro do Cartao do cliente.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class CartaoDAO {

    private CartaoDAO(){}
      
    /** 
     * Função responsavel por armazenar o Cartão de Credito do Cliente no banco de dados.
     * @param cliente - Recebe um objeto Cartão a fim de torna-lo permanente.
     */
    public static void createCartao(Cartao cartao){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(cartao);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Cartão cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos cartões no banco de dados.
     * @param cartao - Recebe um objeto Cartao com ID e os dados a serem atualizados.
     */
    public static void updateCartao(Cartao cartao){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(cartao);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Cartão atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os cartões no banco de dados.
     * @param cartao - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteCartao(int cartao_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Cartao cartao = entityManager.find(Cartao.class, cartao_id);
        entityManager.remove(cartao);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Cartão deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado cartão no banco de dados.
     * @param cartao_id - Chave primaria do objeto cartao.
     * @return Cartao - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Cartao findCartao_byID(int cartao_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Cartao cartao = entityManager.find(Cartao.class, cartao_id);
        
        entityManager.close();

        if (cartao != null){
            System.out.println("Cartão encontrado");
            return cartao;
        } else {
            System.out.println("Cartão não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos cartões presentes no banco de dados.
     * @return List<Cartao> - retorna uma lista com até 10 cartoes.
     */
    public static List<Cartao> readCartoes(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Cartao> cartaoQuery = entityManager.createQuery("from Cartao", Cartao.class);
        List<Cartao> cartoes = cartaoQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (cartoes.size() > 0){
            System.out.println("Cartões encontrados");
            return cartoes;
        } else {
            System.out.println("Não foram encontrados cartões no banco de dados");
            return cartoes;
        }
    }
}
