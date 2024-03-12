package com.suganame.springbootexpert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suganame.springbootexpert.domain.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    
}
