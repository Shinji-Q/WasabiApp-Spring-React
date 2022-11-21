package com.wassabi.wassabiapp.dto;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.model.Produto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Produto2DTO extends RepresentationModel<ProdutoDTO>{


    private Integer produtoId;
	private String produtoNome;
	private double produtoPreco;
	private String produtoDescricao;
    private byte[] produtoImagem;
	private Integer categoriaId;
	private String categoriaDescricao;
    private String categoriaNome;

    public Produto convertDTOToEntity() {
		Categoria cat = new Categoria(categoriaId, categoriaNome, categoriaDescricao);
		Produto prod = new ModelMapper().map(this, Produto.class);
		prod.setCategoria(cat);
		return prod;
	}
}
