package com.suganame.springbootexpert.domain.entities;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Produto {
    private Integer id;
    private String decricao;
    private BigDecimal preco;
}
