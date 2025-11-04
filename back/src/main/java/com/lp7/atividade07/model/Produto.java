package com.lp7.atividade07.model;

import java.math.BigDecimal;

import com.lp7.atividade07.model.enums.StatusProduto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private String nome;
    // CODIGO DE BARRA FUTURAMENTE.
    @Column(nullable = true)
    private String descricao;
    @Column(nullable = true)
    private Integer quantidadeCaixa;
    @Column(nullable = true)
    private BigDecimal precoCusto;
    @Column(nullable = true)
    private BigDecimal precoVenda;
    // DATA DE FABRICAÇÃO FUTURAMENTE.
    // DATA DE VENCIMENTO FUTURAMENTE.
    @Column(nullable = true)
    private StatusProduto status;
    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private Estoque estoque;
}
