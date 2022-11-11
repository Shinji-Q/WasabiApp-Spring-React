package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Produto;

/**
* Interface para realizar o cadastro do Produto.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class ProdutoDAO {

    private ProdutoDAO(){}
      
    /** 
     * Função responsavel por armazenar os produtos no banco de dados.
     * @param produto - Recebe um objeto produto a fim de torna-lo permanente.
     */
    public static void createProduto(Produto ...produtos){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        for (Produto produto : produtos) {
            entityManager.persist(produto);
        }
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Produto cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos produtos no banco de dados.
     * @param produto - Recebe um objeto Produto com ID e os dados a serem atualizados.
     */
    public static void updateProduto(Produto produto){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(produto);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Produto atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os produtos no banco de dados.
     * @param produto - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteProduto(int produto_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Produto produto = entityManager.find(Produto.class, produto_id);
        entityManager.remove(produto);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Produto deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado produto no banco de dados.
     * @param produto_id - Chave primaria do objeto produto.
     * @return Produto - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Produto findProduto_byID(int produto_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Produto produto = entityManager.find(Produto.class, produto_id);
        
        entityManager.close();

        if (produto != null){
            System.out.println("Produto encontrado");
            return produto;
        } else {
            System.out.println("Produto não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos produtos presentes no banco de dados.
     * @return List<Produto> - retorna uma lista com todos produtos.
     */
    public static List<Produto> readProdutos(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Produto> produtoQuery = entityManager.createQuery("from Produto", Produto.class);
        List<Produto> produtos = produtoQuery.getResultList();
        
        entityManager.close();

        if (produtos.size() > 0){
            System.out.println("Produtos encontrados");
            return produtos;
        } else {
            System.out.println("Não foram encontrados produto no banco de dados");
            return produtos;
        }
    }


    /** 
     * Função responsavel por retornar 10 dos produtos presentes no banco de dados.
     * @param quantidade - Define a quantidade de elementos a serem retornados.
     * @return List<Produto> - retorna uma lista com até 10 produtos.
     */
    public static List<Produto> readProdutos(int quantidade){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Produto> produtoQuery = entityManager.createQuery("from Produto", Produto.class);
        List<Produto> produtos = produtoQuery.setMaxResults(quantidade).getResultList();
        
        entityManager.close();

        if (produtos.size() > 0){
            System.out.println("Produtos encontrados");
            return produtos;
        } else {
            System.out.println("Não foram encontrados produto no banco de dados");
            return produtos;
        }
    }
}
