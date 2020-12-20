package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Imovel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    @Query(value = "From Imovel")
    List<Imovel> todos(Sort sort);
}
