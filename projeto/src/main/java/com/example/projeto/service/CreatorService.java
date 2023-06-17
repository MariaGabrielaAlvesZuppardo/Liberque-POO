package com.example.projeto.service;

import com.example.projeto.model.Creator;
import com.example.projeto.repository.CreatorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorService {
    private final CreatorRepository creatorRepository;

    @Autowired
    public CreatorService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    public Creator findByNome(String nome) {
        return creatorRepository.findByNome(nome);
    }

    public Creator addCreator(Creator creator) {
        return creatorRepository.save(creator);
    }

    @Transactional
    public void deleteCreator(int id) {
        creatorRepository.deleteById(id);
    }

    public List<Creator> getAllCreator() {
        return creatorRepository.findAll();
    }

    public void likeCreator(int id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            Creator creator = optionalCreator.get();
            creator.setCurtidas(creator.getCurtidas() + 1);
            creatorRepository.save(creator);
        }
    }




    public Creator adicionarVoto(int id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            Creator creator = optionalCreator.get();
            creator.setVotos(creator.getVotos() + 1);
            creatorRepository.save(creator);
            return creator;
        }
        return null;
    }

    public Creator obterLinkImagem(int id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            return optionalCreator.get();
        }
        return null;
    }

    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    public Creator getCreatorById(int id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        return optionalCreator.orElse(null);
    }

    public void saveCreator(Creator creator) {
        creatorRepository.save(creator);
    }

    public ResponseEntity<Creator> updateCreator(Long id, Creator creator) {
        Optional<Creator> existingCreator = creatorRepository.findById(id);
        if (existingCreator.isPresent()) {
            Creator updatedCreator = existingCreator.get();
            updatedCreator.setNome(creator.getNome()); // Atualize os campos desejados

            creatorRepository.save(updatedCreator);

            return ResponseEntity.ok(updatedCreator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

