package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.wassabi.wassabiapp.model.Produto;

/**
 * ProdutoRepository
 */
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    
}