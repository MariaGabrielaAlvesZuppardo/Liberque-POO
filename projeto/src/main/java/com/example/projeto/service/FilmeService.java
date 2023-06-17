package com.example.projeto.service;

import com.example.projeto.model.Filme;
import com.example.projeto.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme obterFilmePorNome(String nome) {
        Optional<Filme> optionalFilme = filmeRepository.findByNome(nome);
        return optionalFilme.orElse(null);
    }


    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }

    public Filme getFilmeById(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public Filme adicionarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme atualizarFilme(Long id, Filme filme) {
        Filme existingFilme = filmeRepository.findById(id).orElse(null);
        if (existingFilme != null) {
            existingFilme.setNome(filme.getNome());
            return filmeRepository.save(existingFilme);
        }
        return null;
    }

    public void excluirFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public void votarNoFilme(String nome) {
        Filme filme = obterFilmePorNome(nome);
        if (filme != null) {
            filme.setVotos(filme.getVotos() + 1);
            filmeRepository.save(filme);
        }
    }

    public void curtirFilme(String nome) {
        Filme filme = obterFilmePorNome(nome);
        if (filme != null) {
            filme.setCurtidas(filme.getCurtidas() + 1);
            filmeRepository.save(filme);
        }
    }

}

