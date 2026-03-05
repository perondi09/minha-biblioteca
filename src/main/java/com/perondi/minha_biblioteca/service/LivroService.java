package com.perondi.minha_biblioteca.service;

import com.perondi.minha_biblioteca.exceptions.LivroNaoEncontradoException;
import com.perondi.minha_biblioteca.model.LivroModel;
import com.perondi.minha_biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroModel> BuscarTodos() {
        return livroRepository.findAll();
    }

    public LivroModel BuscarPorId(UUID id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado com id: " + id));
    }

    public LivroModel Salvar(LivroModel livro) {
        return livroRepository.save(livro);
    }

    public void Deletar(UUID id) {

        if (!livroRepository.existsById(id)) {
            throw new LivroNaoEncontradoException("Livro não encontrado com id: " + id);
        }
        livroRepository.deleteById(id);
    }

}
