package br.com.project.cardapioAcai.utils.validations.User;

import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;
import br.com.project.cardapioAcai.domain.repositories.UsuarioRepository;
import br.com.project.cardapioAcai.utils.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidation implements UserRegisterValidation{

    @Autowired
    UsuarioRepository userRepository;
    @Override
    public void validar(cadastrarUserDTO dto) {
        var user = userRepository.findByEmail(dto.email());
        if(user.isPresent())
            throw new ValidationException("Email já cadastrado no sistema");
    }
}
