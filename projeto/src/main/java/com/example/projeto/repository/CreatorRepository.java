package com.example.projeto.repository;

import com.example.projeto.model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {
    Creator findByNome(String nome);
    List<Creator> findAll();
    Optional<Creator> findById(int id);

    void deleteById(int id);
}
