package com.suganame.springbootexpert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suganame.springbootexpert.domain.entities.ItemPedido;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {

}
