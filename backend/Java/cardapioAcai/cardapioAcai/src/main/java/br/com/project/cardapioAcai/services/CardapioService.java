package br.com.project.cardapioAcai.services;

import br.com.project.cardapioAcai.domain.dtos.Cardapio.AtualizarCardapioDto;
import br.com.project.cardapioAcai.domain.dtos.Cardapio.CadastrarCardapioDto;
import br.com.project.cardapioAcai.domain.dtos.Cardapio.CardapioResponseDto;
import br.com.project.cardapioAcai.domain.dtos.User.UserResponseDto;
import br.com.project.cardapioAcai.domain.models.Cardapio;
import br.com.project.cardapioAcai.domain.repositories.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CardapioService {
    @Autowired
    CardapioRepository cardapioRepository;

    public ResponseEntity<CardapioResponseDto> cadastrar(CadastrarCardapioDto dto) {
        var cardapio = new Cardapio(dto);
        var response = cardapioRepository.save(cardapio);

        return new ResponseEntity<>(new CardapioResponseDto(response.getId(), response.getNome(), response.getPreco(), response.getIngredientes()), HttpStatus.CREATED);
    }

    public Page<CardapioResponseDto> listar(Pageable paginacao) {
        var cardapios = cardapioRepository.findAll(paginacao);
        return cardapios.map(cardapio -> new CardapioResponseDto(
                cardapio.getId(),
                cardapio.getNome(),
                cardapio.getPreco(),
                cardapio.getIngredientes()
        ));
    }


    public ResponseEntity<CardapioResponseDto> pesquisar(Long id) throws Exception {
        var cardapio = cardapioRepository.findById(id);
        if(cardapio.isEmpty())
            throw new Exception("Não existe cardápio com este id");

        return new ResponseEntity<>(new CardapioResponseDto(cardapio.get().getId(), cardapio.get().getNome(), cardapio.get().getPreco(), cardapio.get().getIngredientes()), HttpStatus.OK);
    }

    public ResponseEntity<CardapioResponseDto> atualizar(Long id, AtualizarCardapioDto dto) throws Exception {
        var cardapio = cardapioRepository.findById(id);
        if (cardapio.isEmpty())
            throw new Exception("Não existe cardápio com este id");

        if(!(dto.nome() == null))
            cardapio.get().setNome(dto.nome());

        if(!(dto.preco() == null))
            cardapio.get().setPreco(dto.preco());

        if(!(dto.ingredientes() == null))
            cardapio.get().setIngredientes(dto.ingredientes());

        cardapioRepository.save(cardapio.get());
        return new ResponseEntity<>(new CardapioResponseDto(cardapio.get().getId(), cardapio.get().getNome(), cardapio.get().getPreco(), cardapio.get().getIngredientes()), HttpStatus.OK);




    }

    public ResponseEntity deletar(Long id) throws Exception {
        var cardapio = cardapioRepository.findById(id);
        if (cardapio.isEmpty())
            throw new Exception("Não existe cardapio com este id");

        cardapioRepository.deleteById(id);
        return new ResponseEntity("Cardápio deletado com sucesso!", HttpStatus.OK);
    }
}
