package com.perondi.minha_biblioteca.service;

import com.perondi.minha_biblioteca.model.UsuarioModel;
import com.perondi.minha_biblioteca.repository.UsuarioRepository;
import io.jsonwebtoken.security.Password;
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

    public UsuarioModel RegistrarUsuario(String nome, String senha) {
       String senhaCriptografada = passwordEncoder.encode(senha);
       UsuarioModel usuarioModel = new UsuarioModel();
       return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> BuscarPorNome(String nome, String senha) {
        return usuarioRepository .findByNome(nome);
    }

}
