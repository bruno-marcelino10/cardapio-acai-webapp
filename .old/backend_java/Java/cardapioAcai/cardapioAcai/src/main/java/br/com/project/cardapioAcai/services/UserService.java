package br.com.project.cardapioAcai.services;

import br.com.project.cardapioAcai.domain.dtos.User.EditarUserDto;
import br.com.project.cardapioAcai.domain.dtos.User.UserResponseDto;
import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;
import br.com.project.cardapioAcai.domain.models.User;
import br.com.project.cardapioAcai.domain.repositories.UsuarioRepository;
import br.com.project.cardapioAcai.utils.validations.User.UserRegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private List<UserRegisterValidation> validacoes;

    public ResponseEntity<UserResponseDto> cadastrar(cadastrarUserDTO dto) {
        validacoes.forEach(v -> v.validar(dto));
        var user = new User(dto);
        var response = usuarioRepository.save(user);
        return new ResponseEntity(new UserResponseDto(response.getId(), response.getEmail()), HttpStatus.CREATED);

    }

    public Page<UserResponseDto> listarUsers(Pageable paginacao) {
        var users = usuarioRepository.findAll(paginacao);

        return users.map(user -> new UserResponseDto(
                user.getId(),
                user.getEmail()
        ));
    }

    public ResponseEntity<UserResponseDto> atualizarUsuario(EditarUserDto dto) throws Exception {
        var user = usuarioRepository.findById(dto.id());
        if(user.isEmpty())
            throw new Exception("Não existe Usuário com este id");

        if(!(dto.email() == null))
            user.get().setEmail(dto.email());

        if(!(dto.password() == null))
            user.get().setPassword(dto.password());

        usuarioRepository.save(user.get());

        return new ResponseEntity<>(new UserResponseDto(user.get().getId(), user.get().getEmail()), HttpStatus.OK);
    }

    public ResponseEntity excluir(Long id) throws Exception {
        var user = usuarioRepository.findById(id);
        if(user.isEmpty())
            throw new Exception("Não existe usuário com este id no sistema");

        usuarioRepository.deleteById(id);
        return new ResponseEntity("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<UserResponseDto> pesquisar(Long id) throws Exception {
        var user = usuarioRepository.findById(id);
        if(user.isEmpty())
            throw new Exception("Não existe usuário com este id no sistema");

        return new ResponseEntity<>(new UserResponseDto(user.get().getId(), user.get().getEmail()), HttpStatus.OK);

    }
}
