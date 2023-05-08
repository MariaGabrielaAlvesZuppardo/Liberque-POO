package com.example.Liberque.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    private String nome;
    private String id;
    private String password;
    private String email;
    private Map<String,List<String>> livrosLidos;
    private Map<String,List<String>> listaDeLeitura;
    private List<String> listaDeEspera;
    private List<String> seriesListaDeEspera;
    private List<String> listaDeDocumentarios;



    
    


}
