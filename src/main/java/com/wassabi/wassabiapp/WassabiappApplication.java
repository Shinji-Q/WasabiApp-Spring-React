package com.wassabi.wassabiapp;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wassabi.wassabiapp.dto.ProdutoDTO;
import com.wassabi.wassabiapp.model.Categoria;
import com.wassabi.wassabiapp.model.Produto;

@SpringBootApplication
public class WassabiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WassabiappApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
		ModelMapper model = new ModelMapper();
		//model.addMappings(new PropertyMap<ProdutoDTO,Produto>() {
		//	@Override
		//	protected void configure() {
		//		map().setCategoria(new Categoria(source.getCategoriaId(), source.getCategoriaNome(), source.getProdutoDescricao()));
		//	}
		//});
        return model;
    }
}
