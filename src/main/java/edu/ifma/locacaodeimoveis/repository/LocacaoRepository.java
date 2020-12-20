package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.model.Imovel;
import edu.ifma.locacaodeimoveis.model.Locacao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LocacaoRepository {

    private final EntityManager manager;
    private final DAOGenerico<Locacao> daoGenerico;


    public LocacaoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public List<Locacao> buscaPor(LocalDate dataInicio) {
        return manager.createQuery("SELECT l FROM Locacao l WHERE l.dataInicio = :data", Locacao.class)
                .setParameter("data", dataInicio)
                .getResultList();
    }

    public Locacao salvaOuAtualiza(Locacao locacao) {
        return daoGenerico.salvaOuAtualiza(locacao);
    }

    public void remove(Locacao locacao) {
        daoGenerico.remove(locacao);
    }

    public List<Imovel> buscaImoveisPor(String bairro) {
        String tipoImovel = "apartamento";
        return manager
                .createQuery("SELECT i FROM Imovel i INNER JOIN Locacao l ON l.imovel.id = i.id WHERE i.bairro = :bairro AND i.tipoImovel = :tipoImovel AND l.ativo = :ativo", Imovel.class)
                .setParameter("bairro", bairro)
                .setParameter("tipoImovel", tipoImovel)
                .setParameter("ativo", false)
                .getResultList();
    }

    public List<Imovel> buscaImoveisDisponiveisPor(BigDecimal valorAluguelSugerido) {
        return manager
                .createQuery("SELECT i FROM Imovel i INNER JOIN Locacao l ON l.imovel.id = i.id WHERE l.ativo = :ativo AND i.valorAluguelSugerido <= :valorAluguelSugerido", Imovel.class)
                .setParameter("valorAluguelSugerido", valorAluguelSugerido)
                .setParameter("ativo", false)
                .getResultList();
    }
}
