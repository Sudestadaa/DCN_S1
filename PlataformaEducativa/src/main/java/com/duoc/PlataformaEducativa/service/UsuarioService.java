package com.duoc.PlataformaEducativa.service;

import com.duoc.PlataformaEducativa.model.Usuario;
import com.duoc.PlataformaEducativa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() { return usuarioRepository.findAll(); }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    public Usuario guardar(Usuario usuario) { return usuarioRepository.save(usuario); }

    public Usuario actualizar(Long id, Usuario usuarioDetalles) {
        Usuario usuario = obtenerPorId(id);
        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setCorreo(usuarioDetalles.getCorreo());
        usuario.setRol(usuarioDetalles.getRol());
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {
        Usuario usuario = obtenerPorId(id);
        usuarioRepository.delete(usuario);
    }
}