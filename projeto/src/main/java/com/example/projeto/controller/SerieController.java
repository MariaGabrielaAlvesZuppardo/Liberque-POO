package com.example.projeto.controller;

import com.example.projeto.model.Serie;
import com.example.projeto.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    public Serie adicionarSerie(@RequestBody Serie serie) {
        return serieService.adicionarSerie(serie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizarSerie(@PathVariable Long id, @RequestBody Serie serie) {
        Serie serieAtualizada = serieService.atualizarSerie(id, serie.getNome(), serie.getGenero(), serie.getDiretor(), serie.getCurtidas(), serie.getComentario(), serie.getVotos());
        return ResponseEntity.ok(serieAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> listarSeries() {
        List<Serie> series = serieService.listarSeries();
        return ResponseEntity.ok(series);
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<Serie> votarSerie(@PathVariable Long id) {
        Serie serie = serieService.votarSerie(id);
        return ResponseEntity.ok(serie);
    }

    @PostMapping("/{id}/curtir")
    public ResponseEntity<Serie> curtirSerie(@PathVariable Long id) {
        Serie serie = serieService.curtirSerie(id);
        return ResponseEntity.ok(serie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSerie(@PathVariable Long id) {
        serieService.deletarSerie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
