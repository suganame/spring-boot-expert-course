package com.suganame.springbootexpert.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suganame.springbootexpert.domain.repositories.Pedidos;
import com.suganame.springbootexpert.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private Pedidos repository;
}
