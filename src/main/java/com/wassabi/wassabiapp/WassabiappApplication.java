package com.wassabi.wassabiapp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WassabiappApplication {
	public static void main(String[] args) {
		SpringApplication.run(WassabiappApplication.class, args);
	}

    
    private static EntityManagerFactory entityManagerFactory = Persistence.
    createEntityManagerFactory("WassabiApp");
    

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
