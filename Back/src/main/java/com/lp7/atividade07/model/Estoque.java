package com.lp7.atividade07.model;

import jakarta.persistence.Entity;

@Entity
public class Estoque {
    private Long id;
    private Produto id_protudo;
    private Integer quantidade;
}
