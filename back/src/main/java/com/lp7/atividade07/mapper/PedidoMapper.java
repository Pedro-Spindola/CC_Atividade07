package com.lp7.atividade07.mapper;

import org.springframework.stereotype.Component;

import com.lp7.atividade07.dto.PedidoRequestDTO;
import com.lp7.atividade07.dto.PedidoResponseDTO;
import com.lp7.atividade07.model.Pedido;

@Component
public class PedidoMapper {
    public Pedido toEntity(PedidoRequestDTO dto ){
    Pedido pedido = new Pedido();

        pedido.setTotal(dto.total());
        pedido.setTroco(dto.troco());
        pedido.setCliente(dto.cliente());
        pedido.setUsuario(dto.usuario());

        return pedido;

    }

    public PedidoResponseDTO TorResponseDTO(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getTotal(),
            pedido.getTroco(),
            pedido.getCliente(),
            pedido.getUsuario()


        );

    }

}
