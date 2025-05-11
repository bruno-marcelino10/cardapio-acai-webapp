package br.com.project.cardapioAcai.domain.repositories;

import br.com.project.cardapioAcai.domain.models.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
