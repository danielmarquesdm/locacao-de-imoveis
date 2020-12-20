package edu.ifma.locacaodeimoveis.repository;

import edu.ifma.locacaodeimoveis.builder.AluguelBuilder;
import edu.ifma.locacaodeimoveis.model.Aluguel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CadastroAluguelTest {
    @Autowired
    private AluguelRepository aluguelRepository;
    private Aluguel aluguel;

    @Before
    public void setUp() {
        aluguelRepository = mock(AluguelRepository.class);
        aluguel = AluguelBuilder.umAluguel()
                .comId(1L).constroi();
    }

    @Test
    public void saveComDataDeVencimentoNulaDeveLancaException() {
        when(aluguelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
                        () -> {
                            aluguel.setDataDeVencimento(null);
                            aluguelRepository.save(aluguel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        assertNotNull(exception);
    }

    @Test
    public void saveComValorPagoNuloDeveLancaException() {
        when(aluguelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
                        () -> {
                            aluguel.setValorPago(null);
                            aluguelRepository.save(aluguel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        assertNotNull(exception);
    }

    @Test
    public void saveComDataDePagamentoNuloDeveLancaException() {
        when(aluguelRepository.save(any())).thenThrow(ConstraintViolationException.class);

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
                        () -> {
                            aluguel.setDataDePagamento(null);
                            aluguelRepository.save(aluguel);
                        },
                        "Deveria Lancar ConstraintViolationException");
        assertNotNull(exception);
    }

}
