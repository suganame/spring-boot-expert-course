package com.suganame.springbootexpert.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String message) {
        super("Pedido não encontrado");
    }
}
