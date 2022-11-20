package com.wassabi.wassabiapp.controller;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wassabi.wassabiapp.dto.ProdutoDTO;
import com.wassabi.wassabiapp.model.Produto;
import com.wassabi.wassabiapp.repository.ProdutoRepository;
import com.wassabi.wassabiapp.service.ProdutoService;
import com.wassabi.wassabiapp.util.FileToMultipartFile;

@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/produto")
    public Iterable<ProdutoDTO> getAllProduto(){
        List<ProdutoDTO> lista = new ArrayList<>();
        produtoService.getAllProduto().forEach(produto -> {
            lista.add(convertToDTO(produto));
        });
        return lista;
    }

    @GetMapping("/produto/{produtoId}")
    public ProdutoDTO getProduto(@PathVariable int produtoId){
        return convertToDTO(produtoService.getProduto(produtoId));
    }

    @PostMapping(value="/produto")
    public Produto createProduto(@ModelAttribute ProdutoDTO produtoDTO) {
        return produtoService.saveProduto(produtoService.getProduto(produtoDTO.getProdutoId()), produtoDTO.getProdutoImagem());
    }

    @PutMapping(value="/produto")
    public Produto updateProduto(@ModelAttribute ProdutoDTO produtoDTO) {
        System.out.println(produtoDTO.convertDTOToEntity());
        return produtoService.saveProduto(produtoDTO.convertDTOToEntity() , produtoDTO.getProdutoImagem());
    }

    @DeleteMapping(value="/produto")
    public void deleteProduto(@RequestBody Produto produto) {
        produtoService.deleteProduto(produto);
    }


    @GetMapping("/produto/cat/{categoriaId}")
    public Iterable<ProdutoDTO> getProdutoByCat(@PathVariable int categoriaId){
        List<ProdutoDTO> lista = new ArrayList<>();
        produtoRepository.findProdutoByCategoria(categoriaId).forEach(produto -> {
            lista.add(convertToDTO(produto));
        });
        return lista;
    }

    private ProdutoDTO convertToDTO(Produto produto) {
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
        if (produto.getProdutoImagem() != null) {
            produtoDTO.setProdutoImagem(getImageFileSystem(produto.getProdutoImagem()));
        }
        return produtoDTO;
    }

    private FileToMultipartFile getImageFileSystem(String filePath) {
        File file = new File(filePath);
        FileToMultipartFile multi = new FileToMultipartFile(file);
        return multi;
    }

    @SuppressWarnings("unused")
    private Iterable<ProdutoDTO> convertProductToDTO(Iterable<Produto> produtos){
        Type listType = new TypeToken<List<ProdutoDTO>>(){}.getType();
        List<ProdutoDTO> postDtoList = modelMapper.map(produtos,listType);
        return postDtoList;
    }
}
