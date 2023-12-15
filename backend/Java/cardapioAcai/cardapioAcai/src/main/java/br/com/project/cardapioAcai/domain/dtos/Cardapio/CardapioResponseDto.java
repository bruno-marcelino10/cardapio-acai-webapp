package br.com.project.cardapioAcai.domain.dtos.Cardapio;

public record CardapioResponseDto(
        Long id,
        String nome,
        Double preco,
        String ingredientes
) {
}
