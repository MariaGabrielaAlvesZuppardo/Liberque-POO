package com.example.projeto.controller;

import com.example.projeto.model.Creator;
import com.example.projeto.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creators")
public class CreatorController {
    private final CreatorService creatorService;

    @Autowired
    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @GetMapping("/nome/{nome}")
    public Creator getCreatorByNome(@PathVariable String nome) {
        return creatorService.findByNome(nome);
    }

    @PostMapping
    public Creator addCreator(@RequestBody Creator creator) {
        return creatorService.addCreator(creator);
    }

    @DeleteMapping("/{id}")
    public void deleteCreator(@PathVariable int id) {
        creatorService.deleteCreator(id);
    }

    @GetMapping
    public ResponseEntity<List<Creator>> getAllCreators() {
        List<Creator> creators = creatorService.getAllCreators();
        return ResponseEntity.ok(creators);
    }

    @PostMapping("/{id}/like")
    public void likeCreator(@PathVariable int id) {
        creatorService.likeCreator(id);
    }



    @PostMapping("/{id}/votar")
    public ResponseEntity<Creator> adicionarVoto(@PathVariable int id) {
        Creator creator = creatorService.adicionarVoto(id);
        if (creator != null) {
            return ResponseEntity.ok(creator);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Creator> getCreatorById(@PathVariable int id) {
        Creator creator = creatorService.getCreatorById(id);
        if (creator != null) {
            return ResponseEntity.ok(creator);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/imagem")
    public ResponseEntity<Creator> obterLinkImagem(@PathVariable int id) {
        Creator creator = creatorService.obterLinkImagem(id);
        if (creator != null) {
            return ResponseEntity.ok(creator);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Creator> updateCreator(@PathVariable Long id, @RequestBody Creator creator) {
        return creatorService.updateCreator(id, creator);
    }
}

