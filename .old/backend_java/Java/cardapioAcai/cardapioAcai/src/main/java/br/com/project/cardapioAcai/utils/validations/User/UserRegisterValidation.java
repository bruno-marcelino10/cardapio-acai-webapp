package br.com.project.cardapioAcai.utils.validations.User;

import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;

public interface UserRegisterValidation {
    void validar(cadastrarUserDTO dto);
}
