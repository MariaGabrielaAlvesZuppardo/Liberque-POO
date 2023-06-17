package com.example.projeto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "Filme")

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "diretor")
    private String diretor;
    @Column(name = "sinopse")
    private String sinopse;
    @Column(name = "genero")
    private String genero;
    @Column(name = "curtidas")
    private int curtidas;
    @Column(name="votos")
    private int votos;


    public Filme(){}


    public Filme(Long id, String nome, String diretor, String sinopse,String genero, int curtidas, int votos){
        this.id=id;
        this.nome=nome;
        this.diretor=diretor;
        this.sinopse=sinopse;
        this.genero=genero;
        this.curtidas=curtidas;
        this.votos=0;
    }

    public void incremetcurtidas(){
        this.curtidas++;
    }
}
