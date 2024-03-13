package com.suganame.springbootexpert.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne()
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade", precision = 20, scale = 2)
    private Integer quantidade;
}
