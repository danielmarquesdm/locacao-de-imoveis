package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.builder.ImovelBuilder;
import edu.ifma.locacaodeimoveis.model.Imovel;
import edu.ifma.locacaodeimoveis.util.EMFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ImovelRepositoryTest {
    private EntityManager manager;
    private static EMFactory factory;
    private ImovelRepository imovelRepository;
    private Imovel imovel;

    @Before
    public void setUp() {
        factory = new EMFactory();
        manager = factory.getEntityManager();
        manager.getTransaction().begin();
        imovelRepository = new ImovelRepository(manager);
        imovel = ImovelBuilder.umImovel().constroi();
    }

    @AfterEach
    public void after() {
        manager.getTransaction().rollback();
    }

    @AfterAll
    public static void end() {
        factory.close();
    }

    @Test
    public void deveAtualizarImovel() {
        imovelRepository.salvaOuAtualiza(imovel);
        imovel.setNome("Casa dos Borges");
        imovelRepository.salvaOuAtualiza(imovel);

        manager.flush();
        manager.clear();

        Imovel imovelAtualizado =
                imovelRepository.buscaPor(imovel.getNome());
        assertThat(imovelAtualizado.getNome(),
                is(equalTo("Casa dos Borges")));
    }

    @Test
    public void deveSalvarImovel() {
        imovelRepository.salvaOuAtualiza(imovel);

        manager.flush();
        manager.clear();

        Imovel imovelSalvo = imovelRepository.buscaPor(imovel.getNome());
        assertThat(imovelSalvo.getNome(), is(equalTo(imovel.getNome())));
    }

    @Test
    public void deveEncontrarImovel() {
        imovelRepository.salvaOuAtualiza(imovel);
        Imovel imovelSalvo = imovelRepository.buscaPor(this.imovel.getNome());
        assertNotNull(imovelSalvo);
        assertEquals(imovel, imovelSalvo);
    }

    @Test
    public void deveExcluirImovel() {
        imovelRepository.remove(imovel);
        assertThrows(NoResultException.class,
                () -> imovelRepository.buscaPor(imovel.getNome()),
                "Deveria ter lançado a exceção NoResultException");
    }
}
