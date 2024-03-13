package com.suganame.springbootexpert.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
}
