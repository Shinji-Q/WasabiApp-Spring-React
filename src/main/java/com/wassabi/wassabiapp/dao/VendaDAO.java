package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Venda;

/**
* Interface para realizar o cadastro do Venda.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class VendaDAO {

    private VendaDAO(){}
      
    /** 
     * Função responsavel por armazenar os vendas no banco de dados.
     * @param venda - Recebe um objeto venda a fim de torna-lo permanente.
     */
    public static void createVenda(Venda venda){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();        
        entityTransaction.begin();
                
        entityManager.detach(venda.getCliente());
        entityManager.persist(venda);
        venda.updateProdutosID();
        entityManager.flush();
        
        entityTransaction.commit();
        entityManager.close();
        
        System.out.println("Venda cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos vendas no banco de dados.
     * @param venda - Recebe um objeto Venda com ID e os dados a serem atualizados.
     */
    public static void updateVenda(Venda venda){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(venda);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Venda atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os vendas no banco de dados.
     * @param venda - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteVenda(Venda venda_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Venda venda = entityManager.find(Venda.class, venda_id);
        entityManager.remove(venda);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Venda deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado venda no banco de dados.
     * @param venda_id - Chave primaria do objeto venda.
     * @return Venda - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Venda findVenda_byID(int venda_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Venda venda = entityManager.find(Venda.class, venda_id);
        
        entityManager.close();

        if (venda != null){
            System.out.println("Venda encontrado");
            return venda;
        } else {
            System.out.println("Venda não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos vendas presentes no banco de dados.
     * @return List<Venda> - retorna uma lista com até 10 vendas.
     */
    public static List<Venda> readVendas(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Venda> vendaQuery = entityManager.createQuery("from Venda", Venda.class);
        List<Venda> vendas = vendaQuery.getResultList();
        
        entityManager.close();

        if (vendas.size() > 0){
            System.out.println("Vendas encontrados");
            return vendas;
        } else {
            System.out.println("Não foram encontrados venda no banco de dados");
            return vendas;
        }
    }

    /** 
     * Função responsavel por retornar 10 dos vendas presentes no banco de dados.
     * @param quantidade - Define a quantidade de elementos a serem encontrados.
     * @return List<Venda> - retorna uma lista com até n vendas.
     */
    public static List<Venda> readVendas(int quantidade){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Venda> vendaQuery = entityManager.createQuery("from Venda", Venda.class);
        List<Venda> vendas = vendaQuery.setMaxResults(quantidade).getResultList();
        
        entityManager.close();

        if (vendas.size() > 0){
            System.out.println("Vendas encontrados");
            return vendas;
        } else {
            System.out.println("Não foram encontrados venda no banco de dados");
            return vendas;
        }
    }
}
