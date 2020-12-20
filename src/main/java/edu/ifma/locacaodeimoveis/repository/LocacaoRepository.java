package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Locacao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    @Query(value = "From Locacao")
    List<Locacao> todos(Sort sort);
}
