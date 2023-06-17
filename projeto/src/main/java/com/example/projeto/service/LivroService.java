package com.example.projeto.service;

import com.example.projeto.model.Livro;
import com.example.projeto.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository=livroRepository;
    }

    public List<Livro> getAllLivros(){
        return livroRepository.findAll();
    }

    public Livro adicionarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livro) {
        Livro existingLivro = livroRepository.findById(id).orElse(null);
        if (existingLivro != null) {
            existingLivro.setTitulo(livro.getTitulo());
            existingLivro.setAutor(livro.getAutor());
            return livroRepository.save(existingLivro);
        }
        return null;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public void votarEmLivro(Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null) {
            livro.setVotos(livro.getVotos() + 1);
            livroRepository.save(livro);
        }
    }

    public void curtirLivro(Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        optionalLivro.ifPresent(livro -> {
            livro.setCurtidas(livro.getCurtidas() + 1);
            livroRepository.save(livro);
        });
    }


}
