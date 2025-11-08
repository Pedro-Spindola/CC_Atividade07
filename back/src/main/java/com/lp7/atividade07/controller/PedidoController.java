package com.lp7.atividade07.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp7.atividade07.service.PedidoService;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {
      
    @Autowired
    PedidoService pedidoService;

}
