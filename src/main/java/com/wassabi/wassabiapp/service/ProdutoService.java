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
            try {
                if (Files.deleteIfExists(new File(UPLOAD_DIRECTORY + produto.getProdutoImagem()).toPath())) {
                    System.out.println("ARQUIVO DELETADO");
                } else {
                    System.out.println("ARQUIVO NÂO DELETADO");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            File folder = new File(UPLOAD_DIRECTORY);
            if (!folder.exists()) {
                folder.mkdir();
            }
            String novo_nome;
            Path path;
            do {
                novo_nome = UUID.randomUUID().toString() + ".png";
                path = Paths.get(UPLOAD_DIRECTORY, novo_nome);
                System.out.println(path.toString());
            
            } while(path.toFile().isFile());
            
            produto.setProdutoImagem(novo_nome);
            produto = saveProduto(produto);
            if (produto.getProdutoId() != 0) {
                try {
                    Files.write(path, file.getBytes());
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
