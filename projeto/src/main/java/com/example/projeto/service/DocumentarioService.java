package com.example.projeto.service;

import com.example.projeto.model.Documentario;
import com.example.projeto.repository.DocumentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentarioService {
    private final DocumentarioRepository documentarioRepository;

    @Autowired
    public DocumentarioService(DocumentarioRepository documentarioRepository) {
        this.documentarioRepository = documentarioRepository;
    }

    public List<Documentario> listarDocumentarios() {
        return documentarioRepository.findAll();
    }

    public Documentario obterDocumentarioPorId(Long id) {
        Optional<Documentario> optionalDocumentario = documentarioRepository.findById(id);
        return optionalDocumentario.orElse(null);
    }

    public Documentario adicionarDocumentario(Documentario documentario) {
        return documentarioRepository.save(documentario);
    }

    public Documentario atualizarDocumentario(Long id, Documentario documentario) {
        documentario.setId(id);
        return documentarioRepository.save(documentario);
    }

    public void excluirDocumentario(Long id) {
        documentarioRepository.deleteById(id);
    }

    public void curtirDocumentario(Long id) {
        Documentario documentario = obterDocumentarioPorId(id);
        if (documentario != null) {
            documentario.setCurtidas(documentario.getCurtidas() + 1);
            documentarioRepository.save(documentario);
        }
    }

    public void votarNoDocumentario(Long id) {
        Documentario documentario = obterDocumentarioPorId(id);
        if (documentario != null) {
            documentario.setVotos(documentario.getVotos() + 1);
            documentarioRepository.save(documentario);
        }
    }
}
