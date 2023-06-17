package com.example.projeto.dto;

public record LivroDTO(Long id, String nome, String autor, String editora, int curtidas, String genero, int votos, String imagemSrc) {
}
