package br.com.project.cardapioAcai.utils.validations.User;

import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;
import br.com.project.cardapioAcai.utils.exceptions.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class PasswordPatternValidation implements UserRegisterValidation{
    @Override
    public void validar(cadastrarUserDTO dto) {
        String senha = dto.password();

        // Comprimento Mínimo = 8 Caracteres
        if(senha.length() < 8)
            throw new ValidationException("A senha inserida possui menos de 8 caracteres");

        // Caracteres Especiais
        if(senha.matches(".*!@#$%¨&*-_.*"))
            throw new ValidationException("A senha inserida não possui nenhuma caractere especial");

        // Letras maíusculas
        if(!senha.matches(".*[A-Z].*"))
            throw new ValidationException("A senha inserida não possui caracteres maiúsculos");

        // Caracteres minúsculos
        if(!senha.matches(".*[a-z].*"))
            throw new ValidationException("A senha inserida não possui caracteres minúsculos");

        // Caracteres numericos
        if(!senha.matches(".*\\d.*"))
            throw new ValidationException(("A senha inserida não possui caracteres numéricos"));
    }
}
