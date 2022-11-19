package com.wassabi.wassabiapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Produto;

/**
 * ProdutoRepository
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query("SELECT c from Produto c WHERE produto_categoria= ?1")
    Iterable<Produto> findProdutoByCategoria(int categoriaId);
}