package com.suganame.springbootexpert.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suganame.springbootexpert.domain.entities.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Object> findByNomeLike(String cli);

}
