package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Produto;

/**
 * ProdutoRepository
 */
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    // public Iterable<Produto> findByCategoria(int categoriaId);

}