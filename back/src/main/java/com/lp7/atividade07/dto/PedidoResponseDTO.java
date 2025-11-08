package com.lp7.atividade07.dto;

import java.math.BigDecimal;

import com.lp7.atividade07.model.Cliente;
import com.lp7.atividade07.model.Usuario;

public record PedidoResponseDTO(
    Long id,
    BigDecimal total,
    BigDecimal troco,
    Cliente cliente,
    Usuario usuario

) {}


