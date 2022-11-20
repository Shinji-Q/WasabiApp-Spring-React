package com.wassabi.wassabiapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WassabiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WassabiappApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
		ModelMapper model = new ModelMapper();
        return model;
    }
}
