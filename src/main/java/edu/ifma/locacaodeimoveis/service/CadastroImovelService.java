package edu.ifma.locacaodeimoveis.service;

import edu.ifma.locacaodeimoveis.model.Imovel;
import edu.ifma.locacaodeimoveis.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CadastroImovelService {
    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel inserirOuAlterar(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public List<Imovel> buscarImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel buscarPor(Long id) {
        return imovelRepository.getOne(id);
    }
}
