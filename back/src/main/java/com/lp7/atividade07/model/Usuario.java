package com.lp7.atividade07.model;

import java.util.List;

import com.lp7.atividade07.model.enums.PerfilUsuario;
import com.lp7.atividade07.model.enums.StatusUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private String nome;
    @Column(nullable = true)
    private String email;
    @Column(nullable = true)
    private String senha;
    @Column(nullable = true)
    private PerfilUsuario perfil;
    @Column(nullable = true)
    private StatusUsuario status;
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidosRegistrados;
}
