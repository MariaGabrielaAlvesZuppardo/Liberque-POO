package com.example.Liberque.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter

public class Series extends Midia{
	
    private String criador;
    private String genero;
    private int numtemporada;


}
