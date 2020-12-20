package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.builder.ImovelBuilder;
import edu.ifma.locacaodeimoveis.model.Imovel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CadastroImovelTest {
    @Autowired
    private ImovelRepository imovelRepository;
    private Imovel imovel;

    @Before
    public void setUp() {
        imovelRepository = mock(ImovelRepository.class);
        imovel = ImovelBuilder.umImovel().comId(1L).constroi();
    }

    @Test
    public void saveComNomeNuloDeveLancaException() {
        when(imovelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = Assertions
                .assertThrows(ConstraintViolationException.class,
                        () -> {
                            imovel.setNome(null);
                            imovelRepository.save(imovel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        Assertions.assertNotNull(exception);
    }

    @Test
    public void saveComEnderecoNuloDeveLancaException() {
        when(imovelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = Assertions
                .assertThrows(ConstraintViolationException.class,
                        () -> {
                            imovel.setEndereco(null);
                            imovelRepository.save(imovel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        Assertions.assertNotNull(exception);
    }

    @Test
    public void saveComBairroNuloDeveLancaException() {
        when(imovelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = Assertions
                .assertThrows(ConstraintViolationException.class,
                        () -> {
                            imovel.setBairro(null);
                            imovelRepository.save(imovel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        Assertions.assertNotNull(exception);
    }
}
