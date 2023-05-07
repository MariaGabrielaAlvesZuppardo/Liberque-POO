package com.example.Liberque.model;

import java.util.ArrayList;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Creators extends Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String canal;
    @ElementCollection
	private String nome;
	private ArrayList<String>conteudosPublicados;
	
    public void publicarConteudo(String conteudo) {
        this.conteudosPublicados.add(conteudo);
        System.out.println("Novo conteúdo publicado por " + this.nome + ": " + conteudo);
    }
	


}
