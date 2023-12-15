package br.com.project.cardapioAcai.utils.validations.User;

import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;
import br.com.project.cardapioAcai.utils.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CheckPasswordValidation implements UserRegisterValidation{
    @Override
    public void validar(cadastrarUserDTO dto) {
        if (!dto.password().equals(dto.confirmPassword()))
            throw new ValidationException("As senhas inseridas são diferentes");
    }
}
