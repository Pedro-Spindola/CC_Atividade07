package com.lp7.atividade07.model;

import com.lp7.atividade07.model.enums.StatusCliente;
import com.lp7.atividade07.model.enums.TipoCliente;

import jakarta.persistence.Entity;

@Entity
public class Cliente {
    private Long id;
    private String nome;
    private TipoCliente tipo;
    private String documento;
    private String endereco;
    private StatusCliente status;
}
