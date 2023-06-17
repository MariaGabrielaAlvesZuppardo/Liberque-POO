package com.example.projeto.repository;

import com.example.projeto.model.Documentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.List;

@Service
public interface DocumentarioRepository extends JpaRepository<Documentario,Long> {
    Documentario findByNome(String nome);
    List<Documentario> findAll();

}
