package com.wassabi.wassabiapp.dto;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.wassabi.wassabiapp.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO extends RepresentationModel<CategoriaDTO> {
    private Integer categoriaId;
	private String categoriaDescricao;
    private String categoriaNome;

    public Categoria convertDTOToEntity() {
		return new ModelMapper().map(this, Categoria.class);
	}
}
