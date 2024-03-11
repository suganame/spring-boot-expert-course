package com.suganame.springbootexpert.domain.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.suganame.springbootexpert.domain.entities.Cliente;

@Repository
public class Clientes {

    private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[] { cliente.getNome() });
        return cliente;
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultset, int i) throws SQLException {
                Integer id = resultset.getInt("id");
                String nome = resultset.getString("nome");
                return new Cliente(id, nome);
            }
        });
    }
}
