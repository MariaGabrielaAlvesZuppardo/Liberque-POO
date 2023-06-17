package com.example.projeto.service;

import com.example.projeto.model.Serie;
import com.example.projeto.repository.SerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    private SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie adicionarSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie atualizarSerie(Long id, String nome, String genero, String diretor, int curtidas, String comentario, int votos) {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Série não encontrada com o ID: " + id));
        serie.setNome(nome);
        serie.setGenero(genero);
        serie.setCurtidas(curtidas);
        serie.setVotos(votos);
        return serieRepository.save(serie);
    }


    public List<Serie> listarSeries() {
        return serieRepository.findAll();
    }

    public Serie votarSerie(Long id) {
        Optional<Serie> optionalSerie = serieRepository.findById(id);
        if (optionalSerie.isPresent()) {
            Serie serie = optionalSerie.get();
            serie.setVotos(serie.getVotos() + 1);
            return serieRepository.save(serie);
        } else {
            throw new IllegalArgumentException("Série não encontrada com o ID: " + id);
        }
    }

    @Transactional
    public Serie curtirSerie(Long id) {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Série não encontrada com o ID: " + id));

        serie.setCurtidas(serie.getCurtidas() + 1);

        return serieRepository.save(serie);
    }

    public void deletarSerie(Long id) {
        serieRepository.deleteById(id);
    }
}
