package com.example.projeto.controller;

import com.example.projeto.model.Filme;
import com.example.projeto.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getAllFilmes() {
        List<Filme> filmes = filmeService.getAllFilmes();
        return ResponseEntity.ok(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        Filme filmeCriado = filmeService.adicionarFilme(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        Filme filmeExistente = filmeService.getFilmeById(id);
        if (filmeExistente != null) {
            filmeExistente.setNome(filme.getNome());
            Filme filmeAtualizado = filmeService.atualizarFilme(id, filmeExistente);
            return ResponseEntity.ok(filmeAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFilme(@PathVariable Long id) {
        filmeService.excluirFilme(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{nome}/votar")
    public ResponseEntity<Void> votarNoFilme(@PathVariable String nome) {
        filmeService.votarNoFilme(nome);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{nome}/curtir")
    public ResponseEntity<Void> curtirFilme(@PathVariable String nome) {
        filmeService.curtirFilme(nome);
        return ResponseEntity.noContent().build();
    }

}







