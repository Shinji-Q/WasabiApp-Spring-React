package com.wassabi.wassabiapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.model.Produto;

/**
 * ProdutoRepositoryTest
 */
@SpringBootTest
public class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;


    @Test
    public void createCategoria(){
        Categoria categoria = new Categoria("categoriaaaa", "alguma_descricao");
        Produto produto = new Produto(categoria, "pizza", 150, "asdasdsadsad");
        produtoRepository.save(produto);
    }
    
}