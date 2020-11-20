package com.ifma.locacaodeimoveis.model;

import java.time.LocalDate;

public class Locacao {
    private int idLocacao;
    private int idImovel;
    private int idInquilino;
    private double valorAluguel;
    private double percentualMulta;
    private int diaVencimento;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativo;
}
