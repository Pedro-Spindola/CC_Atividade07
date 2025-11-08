package com.lp7.atividade07.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp7.atividade07.dto.EstoqueRequestDTO;
import com.lp7.atividade07.dto.EstoqueResponseDTO;
import com.lp7.atividade07.service.EstoqueService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/api/v1/estoque")

public class EstoqueController {
    
     @Autowired
    EstoqueService estoqueService;

    @GetMapping("/produto/{idProduto}")
    public EstoqueResponseDTO buscarEstoquePorIdProduto(@PathVariable Long idProduto){
        return estoqueService.buscarEstoquePorIdProduto(idProduto);
}
    @PutMapping("/atualizar")
    public EstoqueResponseDTO atualizarEstoqueProdutoDTO(@RequestBody EstoqueRequestDTO dto){
        return estoqueService.atualizarEstoqueProduto(dto);
    }






}
