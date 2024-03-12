package com.suganame.springbootexpert.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.suganame.springbootexpert.domain.entities.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    // jpql
    // @Query(value = " select c from Cliente c where c.nome like :nome ")
    // sql nativo
    @Query(value = " select * from CLIENTE c where c.nome like '%:nome%' escape '' ", nativeQuery = true)
    List<Object> encontrarPorNome(@Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome = :nome ")
    @Modifying // utilizar quando for update ou delete
    void deleteByNome(String nome);

    List<Object> findByNomeOrId(String nome, Integer id);

    boolean existsByNome(String nome);

}
