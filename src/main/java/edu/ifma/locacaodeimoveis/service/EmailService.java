package edu.ifma.locacaodeimoveis.service;

import edu.ifma.locacaodeimoveis.model.Aluguel;
import edu.ifma.locacaodeimoveis.model.Cliente;
import edu.ifma.locacaodeimoveis.repository.AluguelRepository;
import edu.ifma.locacaodeimoveis.util.EMFactory;
import edu.ifma.locacaodeimoveis.util.exception.LocacaoException;

import javax.persistence.EntityManager;
import java.util.List;


public class EmailService {
    private static EMFactory factory = new EMFactory();
    private EntityManager manager = factory.getEntityManager();
    private AluguelRepository aluguelRepository = new AluguelRepository(manager);

    public boolean enviaEmailParaClientesEmAtraso() {
        List<Aluguel> alugueisAtrasados = aluguelRepository.emAtraso();
        alugueisAtrasados.forEach(aluguel -> {
            try {
                notificaCliente(aluguel.getLocacao().getInquilino());
            } catch (LocacaoException e) {
                //TODO CASO LANCE EXCEÇÃO DEVE CONTINUAR ENVIANDO EMAIL PARA OS OUTROS INQUILINOS
                System.out.println("ERRO AO NOTIFICAR CLIENTE. " + e.getMessage());
            }
        });
        return true;
    }

    public void notificaCliente(Cliente cliente) throws LocacaoException {
        if (cliente != null) {
            System.out.println("Ola, " + cliente.getNomeCliente() + " Verificamos que seu aluguel nao foi pago na data prevista. Aproveite e pague!");
        } else {
            String erro = "CLIENTE NAO ENCONTRADO.";
            throw new LocacaoException(erro);
        }
    }
}
