package com.suganame.springbootexpert.service;

import java.util.Optional;

import com.suganame.springbootexpert.domain.entities.Pedido;
import com.suganame.springbootexpert.domain.enums.StatusPedido;
import com.suganame.springbootexpert.rest.dtos.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
