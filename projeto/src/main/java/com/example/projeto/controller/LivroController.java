package com.example.projeto.controller;

import com.example.projeto.model.Livro;
import com.example.projeto.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService=livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.getAllLivros();
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.adicionarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.updateLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<Void> votarEmLivro(@PathVariable Long id) {
        livroService.votarEmLivro(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/curtir")
    public ResponseEntity<Void> curtirLivro(@PathVariable Long id) {
        livroService.curtirLivro(id);
        return ResponseEntity.ok().build();
    }
}
