package edu.ifma.locacaodeimoveis.service;

import edu.ifma.locacaodeimoveis.model.Locacao;
import edu.ifma.locacaodeimoveis.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroLocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;

    public Locacao inserirOuAlterar(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public List<Locacao> buscarLocacoes() {
        return locacaoRepository.findAll();
    }
}
