package br.com.project.cardapioAcai.domain.controllers;

import br.com.project.cardapioAcai.domain.dtos.Cardapio.AtualizarCardapioDto;
import br.com.project.cardapioAcai.domain.dtos.Cardapio.CadastrarCardapioDto;
import br.com.project.cardapioAcai.domain.dtos.Cardapio.CardapioResponseDto;
import br.com.project.cardapioAcai.services.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cardapios")
public class CardapioController {

    @Autowired
    CardapioService cardapioService;

    @PostMapping
    public ResponseEntity<CardapioResponseDto> cadastrarCardapio(@RequestBody CadastrarCardapioDto dto){
        return cardapioService.cadastrar(dto);

    }

    @GetMapping
    public Page<CardapioResponseDto> listarCardapio(@PageableDefault(size = 10) Pageable paginacao){
        return cardapioService.listar(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioResponseDto> pesquisarCardapio(@PathVariable Long id) throws Exception {
        return cardapioService.pesquisar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioResponseDto> atualizarCardapio(@PathVariable Long id, @RequestBody AtualizarCardapioDto dto) throws Exception {
        return cardapioService.atualizar(id, dto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCardapio(@PathVariable Long id) throws Exception {
        return cardapioService.deletar(id);
    }
}
