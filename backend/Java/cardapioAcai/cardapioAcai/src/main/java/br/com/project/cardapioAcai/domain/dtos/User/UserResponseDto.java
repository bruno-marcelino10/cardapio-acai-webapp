package br.com.project.cardapioAcai.domain.dtos.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserResponseDto(

        Long id,
        String email
) {
}
