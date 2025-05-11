package br.com.project.cardapioAcai.domain.models;

import br.com.project.cardapioAcai.domain.dtos.Cardapio.CadastrarCardapioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cardapios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private double preco;

    @NotBlank
    private String ingredientes;

    public Cardapio(CadastrarCardapioDto dto) {
        this.nome = dto.nome();
        this.preco = dto.preco();;
        this.ingredientes = dto.ingredientes();
    }
}
