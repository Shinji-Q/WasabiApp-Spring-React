package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.EnderecoId;

/**
* Interface para realizar o cadastro do Endereço do Cliente.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class EnderecoDAO {
    
    private EnderecoDAO() {}
    
    /** 
     * Função responsavel por armazenar o endereço no banco de dados.
     * @param endereco - Instancia de endereço a ser armazenada no banco.
     */
    public static void createEndereco(Endereco endereco){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(endereco);
        entityManager.flush();
        
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Endereço cadastrado com sucesso");
    }

    
    /** 
     * Função responsavel por atualizar os dados dos endereços no banco de dados.
     * @param endereco - Recebe um objeto Endereço com ID e os dados a serem atualizados.
     */
    public static void updateEndereco(Endereco endereco){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(endereco);
        entityManager.flush();
        
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Endereço atualizado com sucesso");
    }

    /** 
     * Função responsavel por deletar um Endereço no banco de dados. Não utilize está função, caso você queira deletar um cliente, seu endereço ira ser deletado junto com ele.
     * Observação, não delete um endereço, pois um cliente deve ter um endereço.
     * @param endereco - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteEndereco(int endereco_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Endereco endereco = entityManager.find(Endereco.class, endereco_id);
        entityManager.remove(endereco);

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Endereco deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado endereco no banco de dados através das chaves primarias.
     * @param endereco_id - Chave priamria, endereco_id, presente na Tabela Endereço.
     * @param cliente_id - Chave priamria, endereco_cliente, presente na Tabela Endereço.
     * @return Endereco - Retorna um Objeto Endereco caso o mesmo seja encontrado caso contrario retorna null.
     */
    public static Endereco findEndereco_byID(int endereco_id, int cliente_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Endereco endereco = entityManager.find(Endereco.class, new EnderecoId(endereco_id, cliente_id));
        
        entityManager.close();

        if (endereco != null){
            System.out.println("Endereço encontrado");
            return endereco;
        } else {
            System.out.println("Endereço não encontrado");
            return null;
        }
    }

    /** 
     * Função responsavel por retornar 10 dos enderecos presentes no banco de dados.
     * @return List<Endereco> - retorna uma lista com até 10 enderecos.
     */
    public static List<Endereco> readEnderecos(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Endereco> enderecoQuery = entityManager.createQuery("from Endereco", Endereco.class);
        List<Endereco> enderecos = enderecoQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (enderecos.size() > 0){
            System.out.println("Enderecos encontrados");
            return enderecos;
        } else {
            System.out.println("Não foram encontrados cliente no banco de dados");
            return enderecos;
        }
    }
    
}
