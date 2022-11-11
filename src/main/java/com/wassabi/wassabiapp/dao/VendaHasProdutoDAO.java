package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.VendaHasProduto;

/**
* Interface para realizar o cadastro do VendaHasProduto.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class VendaHasProdutoDAO {

    private VendaHasProdutoDAO(){}
      
    /** 
     * Função responsavel por armazenar os produtos contidos em uma venda no banco de dados.
     * @param venda - Recebe um objeto venda a fim de torna-lo permanente.
     */
    public static void createVendaHasProduto(VendaHasProduto venda){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        venda.getId().setVendaId(venda.getVenda().getVendaId());
        entityManager.persist(venda);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("VendaHasProduto cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos produtos presentes em uma venda no banco de dados.
     * @param venda - Recebe um objeto VendaHasProduto com ID e os dados a serem atualizados.
     */
    public static void updateVendaHasProduto(VendaHasProduto venda){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(venda);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("VendaHasProduto atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os vendas no banco de dados.
     * @param venda - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteVendaHasProduto(int venda_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        VendaHasProduto venda = entityManager.find(VendaHasProduto.class, venda_id);
        entityManager.remove(venda);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("VendaHasProduto deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado venda no banco de dados.
     * @param venda_id - Chave primaria do objeto venda.
     * @return VendaHasProduto - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static VendaHasProduto findVendaHasProduto_byID(int venda_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        VendaHasProduto venda = entityManager.find(VendaHasProduto.class, venda_id);
        
        entityManager.close();

        if (venda != null){
            System.out.println("VendaHasProduto encontrado");
            return venda;
        } else {
            System.out.println("VendaHasProduto não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos vendas presentes no banco de dados.
     * @return List<VendaHasProduto> - retorna uma lista com até 10 vendas.
     */
    public static List<VendaHasProduto> readVendaHasProdutos(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<VendaHasProduto> vendaQuery = entityManager.createQuery("from VendaHasProduto", VendaHasProduto.class);
        List<VendaHasProduto> vendas = vendaQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (vendas.size() > 0){
            System.out.println("VendaHasProdutos encontrados");
            return vendas;
        } else {
            System.out.println("Não foram encontrados venda no banco de dados");
            return vendas;
        }
    }
}
