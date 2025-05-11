package br.com.project.cardapioAcai.domain.dtos.Cardapio;

import jakarta.validation.constraints.NotBlank;

public record CadastrarCardapioDto(
        @NotBlank
        String nome,

        @NotBlank
        Double preco,

        @NotBlank
        String ingredientes
) {
}
