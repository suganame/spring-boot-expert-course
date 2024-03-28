package com.suganame.springbootexpert.service;

import com.suganame.springbootexpert.domain.entities.Pedido;
import com.suganame.springbootexpert.rest.dtos.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
