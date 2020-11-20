package com.ifma.locacaodeimoveis.model;

import java.time.LocalDate;

public class Aluguel {
    private int idLocacao;
    private LocalDate dataDeVencimento;
    private double valorPago;
    private LocalDate dataDePagamento;

    public Aluguel() {
    }
}
