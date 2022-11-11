package com.wassabi.wassabiapp.populate;

import com.wassabi.wassabiapp.dao.CategoriaDAO;
import com.wassabi.wassabiapp.model.Categoria;

public class CategoriaPOP {

    private CategoriaPOP(){}
    
    public static void populate(){
        Categoria categoria1 = new Categoria("Promoção", "Não tem");
        Categoria categoria2 = new Categoria("Temaki", "Não tem");
        Categoria categoria3 = new Categoria("Entradas", "Não tem");
        Categoria categoria4 = new Categoria("Hall Wassabi", "Não tem");
        CategoriaDAO.createCategoria(categoria1);
        CategoriaDAO.createCategoria(categoria2);
        CategoriaDAO.createCategoria(categoria3);
        CategoriaDAO.createCategoria(categoria4);
    }    
}
