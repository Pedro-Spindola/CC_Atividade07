package com.lp7.atividade07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.EstoqueRequestDTO;
import com.lp7.atividade07.dto.EstoqueResponseDTO;
import com.lp7.atividade07.mapper.EstoqueMapper;
import com.lp7.atividade07.model.Estoque;
import com.lp7.atividade07.repository.EstoqueRepository;
import com.lp7.atividade07.repository.ProdutoRepository;

@Service
public class EstoqueService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    EstoqueMapper estoqueMapper;

  public EstoqueResponseDTO buscarEstoquePorIdProduto(Long idProduto){
    Estoque estoque = estoqueRepository.findByProdutoId(idProduto).orElse(null);
        return estoqueMapper.toResponseDTO(estoque);
}

 // ATUALIZAR / EDITAR ESTOQUE
  public EstoqueResponseDTO atualizarEstoqueProduto(EstoqueRequestDTO dto){
    System.out.println("Meu dto: " + dto.idProduto() + " - " + dto.quantidade());

      Estoque estoque = estoqueRepository.findByProdutoId(dto.idProduto())
        .orElseThrow(() -> new RuntimeException("Estoque não encontrado para o produto ID: " + dto.idProduto()));
      // Atualiza a quantidade
      estoque.setQuantidade(dto.quantidade());
      // Salva no banco
      Estoque salvo = estoqueRepository.save(estoque);
      // Retorna o DTO de resposta
      return estoqueMapper.toResponseDTO(salvo);
  }
}


    

