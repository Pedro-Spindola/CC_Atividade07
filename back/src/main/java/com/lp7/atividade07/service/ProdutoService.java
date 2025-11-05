package com.lp7.atividade07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.ProdutoRequestDTO;
import com.lp7.atividade07.dto.ProdutoResponseDTO;
import com.lp7.atividade07.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
    public ProdutoResponseDTO buscarProdutoID(Long id){
        return null;
        
    }
    public List<ProdutoResponseDTO> listarTodos(){
        return null;
    }
    public ProdutoResponseDTO cadastrarProduto( ProdutoRequestDTO produtoRequestDTO){
        return null;

    }
       public ProdutoResponseDTO atualizarProduto( ProdutoRequestDTO produtoRequestDTO){
        return null;

    }

    public boolean alterarStatus ( Long id){
        return true;

    }
}
