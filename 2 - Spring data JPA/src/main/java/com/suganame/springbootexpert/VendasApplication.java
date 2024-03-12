package com.suganame.springbootexpert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.repositories.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			clientes.save(new Cliente(null, "Guilherme"));
			System.out.println("Salvando Clientes");
			clientes.save(new Cliente(null, "Juliana"));

			boolean exists = clientes.existsByNome("Guilhermee");
			System.out.println("Existe um cliente com o nome Guilherme? " + exists);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
