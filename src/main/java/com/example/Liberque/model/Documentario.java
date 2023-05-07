package com.example.Liberque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Documentario extends Midia  {
    private String diretor;
    private String produtor;
    private String tema;

}
