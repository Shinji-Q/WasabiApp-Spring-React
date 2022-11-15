package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Cartao;
import com.wassabi.wassabiapp.model.CartaoId;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, CartaoId> {
    
}
