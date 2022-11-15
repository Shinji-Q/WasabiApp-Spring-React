package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Produto;
import com.wassabi.wassabiapp.repository.ProdutoRepository;

@Service("ProdutoService")
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto saveProduto(Produto produto){
        produto = produtoRepository.save(produto);
        return produto;
    }

    @Transactional
    public Iterable<Produto> getAllProduto(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto getProduto(int produtoId){
        return produtoRepository.findById(produtoId).get();
    }

    @Transactional
    public void deleteProduto(Produto produto) {
        produtoRepository.delete(produto);
    }
}
