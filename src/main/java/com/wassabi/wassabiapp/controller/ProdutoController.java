package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Produto;
import com.wassabi.wassabiapp.service.ProdutoService;

@RestController
public class ProdutoController {
    private ProdutoService produtoService;

    @Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

    @GetMapping("/produto")
    public Iterable<Produto> getAllProduto(){
        return produtoService.getAllProduto();
    }

    @GetMapping("/produto/{produtoId}")
    public Produto getProduto(@PathVariable int produtoId){
        return produtoService.getProduto(produtoId);
    }

    @PostMapping(value="/produto")
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @PutMapping(value="/produto")
    public Produto updateProduto(@RequestBody Produto produto) {
        produto = produtoService.saveProduto(produto);
        return produto;
    }

    @DeleteMapping(value="/produto")
    public void deleteProduto(@RequestBody Produto produto) {
        produtoService.deleteProduto(produto);
    }
}
