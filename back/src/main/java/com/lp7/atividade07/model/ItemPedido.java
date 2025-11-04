package com.lp7.atividade07.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private Integer quantidade;
    @Column(nullable = true)
    private BigDecimal subTotal;
    @ManyToOne 
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    @ManyToOne 
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
}
