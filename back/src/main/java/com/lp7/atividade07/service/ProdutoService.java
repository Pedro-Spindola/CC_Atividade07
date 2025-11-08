package com.lp7.atividade07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.ProdutoRequestDTO;
import com.lp7.atividade07.dto.ProdutoResponseDTO;
import com.lp7.atividade07.mapper.ProdutoMapper;
import com.lp7.atividade07.model.Estoque;
import com.lp7.atividade07.model.Produto;
import com.lp7.atividade07.model.enums.StatusProduto;
import com.lp7.atividade07.repository.EstoqueRepository;
import com.lp7.atividade07.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoMapper produtoMapper;

    public ProdutoResponseDTO buscarProdutoID(Long id){
        return produtoMapper.toResponseDTO(produtoRepository.findById(id).get());
    }

    public List<ProdutoResponseDTO> listarTodos(){
        return produtoRepository.findAll().stream()
                    .map(produtoMapper::toResponseDTO)
                    .toList();
    }

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Estoque estoque = new Estoque();
        Produto produto = produtoMapper.toEntity(produtoRequestDTO, estoque);

        estoque.setProduto(produto);
        estoque.setQuantidade(0);
        produto.setEstoque(estoque);

        Produto salvo = produtoRepository.save(produto);
        return produtoMapper.toResponseDTO(salvo);
    }

    public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequestDTO){
        Estoque estoque = estoqueRepository.findById(produtoRequestDTO.id()).get();
        Produto produto = produtoMapper.toEntity(produtoRequestDTO, estoque);

        return produtoMapper.toResponseDTO(produtoRepository.save(produto));
    }

    public boolean alterarStatus ( Long id){
        Produto produto = produtoRepository.findById(id).get();
        if(produto.getStatus() == StatusProduto.ATIVO) produto.setStatus(StatusProduto.INATIVO);
        else produto.setStatus(StatusProduto.ATIVO);
        produtoRepository.save(produto);
        return true;
    }
}
