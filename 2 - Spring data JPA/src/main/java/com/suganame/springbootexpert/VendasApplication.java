package com.suganame.springbootexpert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.entities.Pedido;
import com.suganame.springbootexpert.domain.repositories.Clientes;
import com.suganame.springbootexpert.domain.repositories.Pedidos;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos) {
		return args -> {
			Cliente c = new Cliente("Guilherme");
			clientes.save(c);

			Pedido p = new Pedido();
			p.setCliente(c);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			pedidos.findByCliente(c).forEach(System.out::println);
			// Cliente cliente = clientes.findClienteFetchPedidos(c.getId());
			// System.out.println(cliente);
			// System.out.println(cliente.getPedidos());

			// clientes.save(new Cliente(null, "Guilherme"));
			// System.out.println("Salvando Clientes");
			// clientes.save(new Cliente(null, "Juliana"));

			// boolean exists = clientes.existsByNome("Guilhermee");
			// System.out.println("Existe um cliente com o nome Guilherme? " + exists);

			// System.out.println("Buscando Clientes");
			// clientes.encontrarPorNome("Gui").forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
