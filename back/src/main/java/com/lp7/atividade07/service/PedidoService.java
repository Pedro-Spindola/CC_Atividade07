package com.lp7.atividade07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.PedidoRequestDTO;
import com.lp7.atividade07.dto.PedidoResponseDTO;
import com.lp7.atividade07.mapper.PedidoMapper;
import com.lp7.atividade07.model.Pedido;
import com.lp7.atividade07.repository.PedidoRepository;

@Service
public class PedidoService {
   @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    // BUSCAR PEDIDO POR ID
    public PedidoResponseDTO buscarPedidoPorId(Long idPedido){
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        return pedidoMapper.TorResponseDTO(pedido);
    }

    // REGISTRAR (CRIAR) PEDIDO
    public PedidoResponseDTO registrarPedido(PedidoRequestDTO dto){
        Pedido pedido = pedidoMapper.toEntity(dto);
        Pedido salvo = pedidoRepository.save(pedido);
        return pedidoMapper.TorResponseDTO(salvo);
    }

    // ATUALIZAR PEDIDO
    public PedidoResponseDTO atualizarPedido(PedidoRequestDTO dto, Long idPedido){
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);

        pedido.setTotal(dto.total());
        pedido.setTroco(dto.troco());
        pedido.setCliente(dto.cliente());
        pedido.setUsuario(dto.usuario());

        Pedido salvo = pedidoRepository.save(pedido);
        return pedidoMapper.TorResponseDTO(salvo);
    }

    // BUSCAR TODOS OS PEDIDOS
    public List<PedidoResponseDTO> buscarTodos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                      .map(pedidoMapper::TorResponseDTO)
                      .toList();
    }
}




