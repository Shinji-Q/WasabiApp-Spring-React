package com.wassabi.wassabiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.service.CategoriaService;

@CrossOrigin(origins = "http://localhost:80")
@RestController
public class CategoriaController {
    private CategoriaService categriaService;

    @Autowired
	public CategoriaController(CategoriaService categriaService) {
		this.categriaService = categriaService;
	}

    @GetMapping("/categoria")
    public Iterable<Categoria> getAllCategoria(){
        return categriaService.getAllCategoria();
    }

    @GetMapping("/categoria/{categoriaId}")
    public Categoria getCategoria(@PathVariable int categoriaId){
        return categriaService.getCategoria(categoriaId);
    }

    @PostMapping(value="/categoria")
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categriaService.saveCategoria(categoria);
    }

    @PutMapping(value="/categoria")
    public Categoria updateCategoria(@RequestBody Categoria categoria) {
        categoria = categriaService.saveCategoria(categoria);
        return categoria;
    }

    @DeleteMapping(value="/categoria")
    public void deleteCategoria(@RequestBody Categoria categoria) {
        categriaService.deleteCategoria(categoria);
    }
}
