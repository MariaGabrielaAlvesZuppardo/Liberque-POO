package com.example.Liberque.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class Livro extends Midia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    private String editora;

    private String genero;

    @ElementCollection
    private List<Integer> avaliacoes = new ArrayList<>();

    @ElementCollection
    private List<String> comentarios = new ArrayList<>();
    
    // Metodo para avaliação que o livro pode receber

    public void adicionarAvaliacao(int avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public double calcularMediaAvaliacoes() {
        if (this.avaliacoes.isEmpty()) {
            return 0;
        }

        int somaAvaliacoes = 0;
        for (int avaliacao : this.avaliacoes) {
            somaAvaliacoes += avaliacao;
        }

        return (double) somaAvaliacoes / this.avaliacoes.size();
    }

    // Metodo para adicionar um comentario a um usuario
    public void adicionarComentario(String comentario) {
        comentarios.add(comentario);
    }
    

    }

