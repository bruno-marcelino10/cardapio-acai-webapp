package br.com.project.cardapioAcai.domain.dtos.Cardapio;

import jakarta.validation.constraints.NotBlank;

public record AtualizarCardapioDto(
        String nome,
        Double preco,
        String ingredientes
) {
}
