package com.example.projeto.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity


@Table(name = "Documentario")

public class Documentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopse")
    private String sinopse;
    @Column(name = "diretor")
    private String diretor;
    @Column(name = "curtidas")
    private int curtidas;
    @Column(name = "votos")
    private int votos;

    public Documentario(){

    }
    public Documentario(Long id, String nome, String genero, String sinopse, String diretor, int curtidas, int votos){
        this.id=id;
        this.nome=nome;
        this.genero=genero;
        this.sinopse=sinopse;
        this.diretor=diretor;
        this.curtidas=curtidas;
        this.votos=votos;
    }
}
