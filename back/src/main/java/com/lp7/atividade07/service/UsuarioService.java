package com.lp7.atividade07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp7.atividade07.dto.LoginRequestDTO;
import com.lp7.atividade07.dto.UsuarioRequestDTO;
import com.lp7.atividade07.dto.UsuarioResponseDTO;
import com.lp7.atividade07.mapper.UsuarioMapper;
import com.lp7.atividade07.model.Usuario;
import com.lp7.atividade07.model.enums.PerfilUsuario;
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
        return usuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO autenticar(LoginRequestDTO request) throws Exception {
        
        // return UsuarioResponseDTO;
        // Fazer validação e implementar depois.
        return usuarioMapper.toResponseDTO(usuarioRepository.findByEmail(request.email()).get());
        
        // Falha! Lança uma exceção que o Controller vai pegar
        // throw new Exception("Usuário ou senha inválidos");
    }

    public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO dto){
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(salvo);
    }

    public UsuarioResponseDTO atualizarUsuario(UsuarioRequestDTO dto, Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setPerfil(dto.perfil());
        usuario.setStatus(dto.status());

        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> buscarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                       .map(usuarioMapper::toResponseDTO)
                       .toList();
    }

    public UsuarioResponseDTO inativarUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if(usuario.getStatus() == StatusUsuario.ATIVO) usuario.setStatus(StatusUsuario.INATIVO);
        else usuario.setStatus(StatusUsuario.ATIVO);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(salvo);
    }
}
    

