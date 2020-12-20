package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "From Cliente")
    List<Cliente> todos(Sort sort);
}
