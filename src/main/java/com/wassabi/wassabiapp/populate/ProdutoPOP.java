package com.wassabi.wassabiapp.populate;

import com.wassabi.wassabiapp.dao.CategoriaDAO;
import com.wassabi.wassabiapp.dao.ProdutoDAO;
import com.wassabi.wassabiapp.model.Produto;

public class ProdutoPOP {
    private ProdutoPOP(){}

    public static void populate(){
        Produto produto = new Produto(CategoriaDAO.findCategoria_byID(1), "Pizza", 100, "null");
        Produto produto2 = new Produto(CategoriaDAO.findCategoria_byID(2), "Pizza", 100, "null");
        Produto produto3 = new Produto(CategoriaDAO.findCategoria_byID(3), "Pizza", 100, "null");
        Produto produto4 = new Produto(CategoriaDAO.findCategoria_byID(4), "Pizza", 100, "null");

        ProdutoDAO.createProduto(produto, produto2, produto3, produto4);
    }
}
