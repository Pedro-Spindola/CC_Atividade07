package com.lp7.atividade07.model;

import java.util.List;

import com.lp7.atividade07.model.enums.StatusCliente;
import com.lp7.atividade07.model.enums.TipoCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private String nome;
    @Column(nullable = true)
    private TipoCliente tipo;
    @Column(nullable = true)
    private String documento;
    @Column(nullable = true)
    private String endereco;
    @Column(nullable = true)
    private StatusCliente status;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}
