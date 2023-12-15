package br.com.project.cardapioAcai.domain.controllers;

import br.com.project.cardapioAcai.domain.dtos.User.EditarUserDto;
import br.com.project.cardapioAcai.domain.dtos.User.UserResponseDto;
import br.com.project.cardapioAcai.domain.dtos.User.cadastrarUserDTO;
import br.com.project.cardapioAcai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> cadastrarUsuario(@RequestBody cadastrarUserDTO dto){
        return userService.cadastrar(dto);
    }

    @GetMapping
    public Page<UserResponseDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return userService.listarUsers(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> pesquisarUsuario(@PathVariable Long id) throws Exception {
        return userService.pesquisar(id);
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> editarUsuario(@RequestBody EditarUserDto dto) throws Exception {
        return userService.atualizarUsuario(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirUsuario(@PathVariable Long id) throws Exception {
        return userService.excluir(id);
    }

}
