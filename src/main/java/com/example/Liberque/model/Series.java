package com.example.Liberque.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Series extends Midia{
	
    private String criador;
    private String genero;
    private int numtemporada;


}
