package com.lp7.atividade07.model;

import java.math.BigDecimal;

import com.lp7.atividade07.model.enums.StatusProduto;

import jakarta.persistence.Entity;

@Entity
public class Produto {
    private Long id;
    private String nome;
    // CODIGO DE BARRA FUTURAMENTE.
    private String descricao;
    private Integer quantidadeCaixa;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    // DATA DE FABRICAÇÃO FUTURAMENTE.
    // DATA DE VENCIMENTO FUTURAMENTE.
    private StatusProduto status;
}
