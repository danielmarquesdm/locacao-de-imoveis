package edu.ifma.locacaodeimoveis.service;

import edu.ifma.locacaodeimoveis.model.Aluguel;
import edu.ifma.locacaodeimoveis.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroAluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    public Aluguel inserirOuAlterar(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> buscarAlugueis() {
        return aluguelRepository.findAll();
    }
}
