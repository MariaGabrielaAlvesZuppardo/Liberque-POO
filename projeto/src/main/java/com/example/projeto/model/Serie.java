package com.example.projeto.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter

@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name="genero")
    private String genero;
    @Column(name = "diretor")
    private String diretor;
    @Column(name = "curtidas")
    private int curtidas;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "votos")
    private int votos;

    public Serie(){

    }

    public Serie(Long id,String nome,String genero,String diretor, int curtidas,String comentario,int votos){
        this.id=id;
        this.nome=nome;
        this.diretor=diretor;
        this.genero=genero;
        this.curtidas=curtidas;
        this.comentario=comentario;
        this.votos=votos;
    }


}
