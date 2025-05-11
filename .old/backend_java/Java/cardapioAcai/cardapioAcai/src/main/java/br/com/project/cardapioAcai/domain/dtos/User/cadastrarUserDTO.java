package br.com.project.cardapioAcai.domain.dtos.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record cadastrarUserDTO(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String password,

        @NotBlank
        String confirmPassword
) {
}
