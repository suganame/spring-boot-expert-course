package com.suganame.springbootexpert.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suganame.springbootexpert.domain.entities.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{
    
}
