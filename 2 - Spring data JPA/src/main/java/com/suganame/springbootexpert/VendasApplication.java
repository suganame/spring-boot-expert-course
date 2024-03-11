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
			clientes.salvar(new Cliente(null, "Guilherme"));
			System.out.println("Salvando Clientes");
			clientes.salvar(new Cliente(null, "Juliana"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando Clientes");

			todosClientes.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + " atualizado.");
				clientes.atualizar(cliente);
			});

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando Clientes");
			clientes.buscarPorNome("Gui").forEach(System.out::println);

			System.out.println("Deletando Clientes");
			clientes.obterTodos().forEach(cliente -> {
				clientes.deletar(cliente);
			});

			todosClientes = clientes.obterTodos();

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
