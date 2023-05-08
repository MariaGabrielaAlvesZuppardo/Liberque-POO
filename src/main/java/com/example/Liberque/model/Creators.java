package com.example.Liberque.model;

import java.util.ArrayList;
import java.util.Collection;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter


public class Creators extends Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String canal;
    @ElementCollection
	private String nome;
	private ArrayList<Midia>conteudosPublicados;
    
    public void publicarConteudo(Collection<? extends Midia> conteudo) {
        this.conteudosPublicados.addAll(conteudo);
        System.out.println("Novo conteúdo publicado por " + this.nome + ": " + conteudo);
    }

}
