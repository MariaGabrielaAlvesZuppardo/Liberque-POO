package com.example.projeto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "livro")
public class Livro {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "titulo")
        private String titulo;
        @Column(name="autor")
        private String autor;
        @Column(name = "editora")
        private String editora;
        @Column(name = "genero")
        private String genero;
        @Column(name = "curtidas")
        private int curtidas;
        @Column(name = "votos")
        private int votos;

        public Livro(){

        }

    public Livro(Long id, String titulo, String autor, String editora, String genero, int curtidas) {
        this.id=id;
        this.titulo=titulo;
        this.editora=editora;
        this.genero=genero;
        this.autor = autor;
        this.curtidas=curtidas;

    }
}

