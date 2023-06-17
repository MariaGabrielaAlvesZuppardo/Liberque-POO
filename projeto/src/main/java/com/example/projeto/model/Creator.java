package com.example.projeto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data

@Table(name = "creator")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    @JsonProperty("nome")
    private String nome;
    @Column(name="genero")
    private String genero;
    @Column(name = "curtidas")
    private int curtidas;
    @Column(name = "votos")
    private int votos;


    public Creator(){
    }
    public Creator(int id, String nome, String genero, int curtidas, int votos) {
        this.id=id;
        this.nome = nome;
        this.genero = genero;
        this.curtidas=curtidas;
        this.votos=0;
    }

}
