package com.wassabi.wassabiapp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wassabi.wassabiapp.model.Produto;
import com.wassabi.wassabiapp.repository.ProdutoRepository;

@Service("ProdutoService")
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/bd/images/";

    @Transactional
    public Produto saveProduto(Produto produto, MultipartFile file){
        if (file != null) {
            File folder = new File(UPLOAD_DIRECTORY);
            if (!folder.exists()) {
                folder.mkdir();
            }
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, UUID.randomUUID().toString().substring(0, 20) + file.getOriginalFilename());
            produto.setProdutoImagem(fileNameAndPath.toString());
            produto = saveProduto(produto);
            if (produto.getProdutoId() != 0) {
                try {
                    Files.write(fileNameAndPath, file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }                
            }
        } else {
            produto = saveProduto(produto);
        }
        return produto;
    }

    @Transactional
    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
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

    // @Transactional
    // public Iterable<Produto> getProdutoByCategoria(int categoriaId){
    //     return produtoRepository.findByCategoria(categoriaId);
    // }

}
