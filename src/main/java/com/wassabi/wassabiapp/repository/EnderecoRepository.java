package com.wassabi.wassabiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wassabi.wassabiapp.model.Endereco;
import com.wassabi.wassabiapp.model.EnderecoId;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, EnderecoId>{
}
