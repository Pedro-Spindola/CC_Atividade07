package com.lp7.atividade07.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp7.atividade07.service.UsuarioService;
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
        @Autowired
         UsuarioService usuarioService;


}
