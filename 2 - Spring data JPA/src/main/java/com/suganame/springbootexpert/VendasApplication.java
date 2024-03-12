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

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando Clientes");

			todosClientes.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + " atualizado.");
				clientes.save(cliente);
			});

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando Clientes");
			clientes.findByNomeLike("Gui").forEach(System.out::println);

			System.out.println("Deletando Clientes");
			clientes.findAll().forEach(cliente -> {
				clientes.delete(cliente);
			});

			todosClientes = clientes.findAll();

			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum Cliente encontrado.");
			} else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
