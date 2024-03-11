package com.suganame.springbootexpert.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Pedido {
    private Integer id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
}
