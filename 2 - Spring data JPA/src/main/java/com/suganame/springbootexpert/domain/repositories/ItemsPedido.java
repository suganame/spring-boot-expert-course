package com.suganame.springbootexpert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suganame.springbootexpert.domain.entities.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer>{
    
}
