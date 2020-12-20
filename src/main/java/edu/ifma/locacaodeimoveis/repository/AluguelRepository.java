package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Aluguel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    @Query(value = "From Aluguel")
    List<Aluguel> todos(Sort sort);
}
