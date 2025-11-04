package com.lp7.atividade07.model;

import com.lp7.atividade07.model.enums.PerfilUsuario;
import com.lp7.atividade07.model.enums.StatusUsuario;

import jakarta.persistence.Entity;

@Entity
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private PerfilUsuario perfil;
    private StatusUsuario status;
}
