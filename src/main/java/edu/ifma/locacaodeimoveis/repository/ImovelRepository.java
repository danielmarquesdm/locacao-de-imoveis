package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Imovel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    @Query(value = "From Imovel")
    List<Imovel> todos(Sort sort);

    @Query(value = "From Imovel i where i.tipoImovel = :tipo")
    List<Imovel> findBy(@Param("tipo") String tipoImovel);
}
