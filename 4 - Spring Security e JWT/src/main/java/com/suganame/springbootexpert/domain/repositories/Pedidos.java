package com.suganame.springbootexpert.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);

    @Query(" select p from Pedido p left join fetch p.itens where p.id = :id ")
    Optional<Pedido> findByIdFetchItens(Integer id);
}
