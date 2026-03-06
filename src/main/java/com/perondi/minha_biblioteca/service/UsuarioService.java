package com.perondi.minha_biblioteca.service;

import com.perondi.minha_biblioteca.model.UsuarioModel;
import com.perondi.minha_biblioteca.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UsuarioModel registrarUsuario(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        UsuarioModel usuario = new UsuarioModel();
        usuario.setUsername(username);
        usuario.setPassword(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

}
