package com.example.projeto.controller;

import com.example.projeto.model.Documentario;
import com.example.projeto.service.DocumentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentarios")
public class DocumentarioController {
    private final DocumentarioService documentarioService;

    @Autowired
    public DocumentarioController(DocumentarioService documentarioService) {
        this.documentarioService = documentarioService;
    }

    @GetMapping
    public List<Documentario> listarDocumentarios() {
        return documentarioService.listarDocumentarios();
    }


    @PostMapping
    public ResponseEntity<Documentario> adicionarDocumentario(@RequestBody Documentario documentario) {
        Documentario documentarioCriado = documentarioService.adicionarDocumentario(documentario);
        return ResponseEntity.ok(documentarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documentario> atualizarDocumentario(@PathVariable Long id, @RequestBody Documentario documentario) {
        Documentario documentarioExistente = documentarioService.obterDocumentarioPorId(id);
        if (documentarioExistente != null) {
            Documentario documentarioAtualizado = documentarioService.atualizarDocumentario(id, documentario);
            return ResponseEntity.ok(documentarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDocumentario(@PathVariable Long id) {
        Documentario documentarioExistente = documentarioService.obterDocumentarioPorId(id);
        if (documentarioExistente != null) {
            documentarioService.excluirDocumentario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/curtir")
    public ResponseEntity<Void> curtirDocumentario(@PathVariable Long id) {
        documentarioService.curtirDocumentario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<Void> votarNoDocumentario(@PathVariable Long id) {
        documentarioService.votarNoDocumentario(id);
        return ResponseEntity.noContent().build();
    }
}
