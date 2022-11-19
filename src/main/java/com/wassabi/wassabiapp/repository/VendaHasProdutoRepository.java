package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.VendaHasProduto;
import com.wassabi.wassabiapp.model.VendaHasProdutoId;

@Repository
public interface VendaHasProdutoRepository extends CrudRepository<VendaHasProduto, VendaHasProdutoId>{
    
}
