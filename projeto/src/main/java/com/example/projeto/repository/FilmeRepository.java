package com.example.projeto.repository;

import com.example.projeto.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {
    Optional<Filme> findByNome(String nome);

    List<Filme>findAll();

    Filme deleteByNome(String nome);


}
