package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp7.atividade07.service.ClienteService;
@RestController
@RequestMapping("/api/v1/cliente")

public class ClienteController {
       @Autowired
    ClienteService clienteService;


}
