package com.suganame.springbootexpert.rest.dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
