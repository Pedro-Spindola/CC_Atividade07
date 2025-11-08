package com.lp7.atividade07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.UsuarioRequestDTO;
import com.lp7.atividade07.dto.UsuarioResponseDTO;
import com.lp7.atividade07.mapper.UsuarioMapper;
import com.lp7.atividade07.model.Usuario;
import com.lp7.atividade07.model.enums.StatusUsuario;
import com.lp7.atividade07.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO buscarUsuarioPorId(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        return usuarioMapper.tResponseDTO(usuario);
    }

    public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO dto){
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.tResponseDTO(salvo);
    }

    public UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO dto, Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setPerfil(dto.perfil());
        usuario.setStatus(dto.status());

        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.tResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> buscarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                       .map(usuarioMapper::tResponseDTO)
                       .toList();
    }

    public UsuarioResponseDTO inativarUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        usuario.setStatus(StatusUsuario.INATIVO);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.tResponseDTO(salvo);
    }
}
    

