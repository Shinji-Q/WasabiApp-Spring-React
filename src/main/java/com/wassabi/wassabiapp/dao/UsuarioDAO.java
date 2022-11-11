package com.wassabi.wassabiapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.wassabiapp.WassabiappApplication;
import com.wassabi.wassabiapp.model.Usuario;

/**
* Interface para realizar o cadastro do Usuario do cliente.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class UsuarioDAO {

    private UsuarioDAO(){}
      
    /** 
     * Função responsavel por armazenar o Usuario de Credito do Cliente no banco de dados.
     * @param cliente - Recebe um objeto Usuario a fim de torna-lo permanente.
     */
    public static void createUsuario(Usuario usuario){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(usuario);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Usuario cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos cartões no banco de dados.
     * @param usuario - Recebe um objeto Usuario com ID e os dados a serem atualizados.
     */
    public static void updateUsuario(Usuario usuario){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(usuario);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Usuario atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os cartões no banco de dados.
     * @param usuario - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteUsuario(int usuario_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Usuario usuario = entityManager.find(Usuario.class, usuario_id);
        entityManager.remove(usuario);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Usuario deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado cartão no banco de dados.
     * @param usuario_id - Chave primaria do objeto usuario.
     * @return Usuario - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Usuario findUsuario_byID(int usuario_id){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Usuario usuario = entityManager.find(Usuario.class, usuario_id);
        
        entityManager.close();

        if (usuario != null){
            System.out.println("Usuario encontrado");
            return usuario;
        } else {
            System.out.println("Usuario não encontrado");
            return null;
        }
    }


    /** 
     * Função responsavel por encontrar um determinado cartão no banco de dados.
     * @param usuario_email - Chave primaria do objeto usuario.
     * @return Usuario - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Usuario findUsuario_byEmail(String usuario_email){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Usuario usuario = (Usuario) entityManager.createNativeQuery(String.format("select * from Usuario where usuario_email='%s'", usuario_email), Usuario.class).getSingleResult();
        entityManager.close();

        if (usuario != null){
            System.out.println("Usuario encontrado");
            return usuario;
        } else {
            System.out.println("Usuario não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos cartões presentes no banco de dados.
     * @return List<Usuario> - retorna uma lista com até 10 cartoes.
     */
    public static List<Usuario> readCartoes(){
        EntityManagerFactory entityManagerFactory = WassabiappApplication.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Usuario> usuarioQuery = entityManager.createQuery("from Usuario", Usuario.class);
        List<Usuario> cartoes = usuarioQuery.setMaxResults(10).getResultList();
        
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
