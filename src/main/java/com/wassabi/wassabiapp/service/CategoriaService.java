package com.wassabi.wassabiapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.repository.CategoriaRepository;

@Service("CategoriaService")
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria saveCategoria(Categoria categoria){
        categoria = categoriaRepository.save(categoria);
        return categoria;
    }

    @Transactional
    public Iterable<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    @Transactional
    public Categoria getCategoria(int categoriaId){
        return categoriaRepository.findById(categoriaId).get();
    }

    @Transactional
    public void deleteCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
