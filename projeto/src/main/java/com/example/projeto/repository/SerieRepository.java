package com.example.projeto.repository;

import com.example.projeto.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {
    Serie findByNome(String nome);
    Serie save(Serie serie);
}
