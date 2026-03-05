package com.perondi.minha_biblioteca.controller;

import com.perondi.minha_biblioteca.exceptions.LivroNaoEncontradoException;
import com.perondi.minha_biblioteca.model.LivroModel;
import com.perondi.minha_biblioteca.service.LivroService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livros")

public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroModel> BuscarTodos() {
        return livroService.BuscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorId(@PathVariable UUID id) {
        LivroModel livro = livroService.BuscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public LivroModel Salvar(@RequestBody LivroModel livro) {
        return livroService.Salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable UUID id) {
        livroService.Deletar(id);
    }
}
