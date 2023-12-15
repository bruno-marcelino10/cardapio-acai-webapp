package br.com.project.cardapioAcai.domain.dtos.User;

import jakarta.validation.constraints.NotNull;

public record EditarUserDto (
        @NotNull
        Long id,
        String email,
        String password
) {
}
