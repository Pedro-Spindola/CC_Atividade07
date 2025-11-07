package com.lp7.atividade07.dto;

import com.lp7.atividade07.model.enums.StatusProduto;

public record ClienteRequestDTO(
   Long id,
    String nome,
    StatusProduto status
) {}
    

