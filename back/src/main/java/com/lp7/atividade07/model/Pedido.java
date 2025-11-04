package com.lp7.atividade07.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Pedido {
    private Long id;
    private BigDecimal total;
    private BigDecimal troco;
    private Cliente id_cliente;
    private Usuario id_Usuario;
    private List<ItemPedido> itensPedido;
}
