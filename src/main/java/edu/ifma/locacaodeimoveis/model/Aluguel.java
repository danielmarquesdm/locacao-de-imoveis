package edu.ifma.locacaodeimoveis.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Aluguel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idAluguel;

    @ManyToOne
    private Locacao locacao;
    @NotEmpty(message = "A data de vencimento deve ser preenchida")
    private LocalDate dataDeVencimento;
    @NotEmpty(message = "O valor pago deve ser preenchido")
    private BigDecimal valorPago;
    @NotEmpty(message = "A data de pagamento deve ser preenchida")
    private LocalDate dataDePagamento;
    private String observacao;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataDeVencimento == null) ? 0 : dataDeVencimento.hashCode());
        result = prime * result + ((valorPago == null) ? 0 : valorPago.hashCode());
        result = prime * result + ((dataDePagamento == null) ? 0 : dataDePagamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) obj;
        if (dataDeVencimento == null) {
            if (other.dataDeVencimento != null) {
                return false;
            }
        } else if (!dataDeVencimento.equals(other.dataDeVencimento)) {
            return false;
        }
        if (valorPago == null) {
            if (other.valorPago != null) {
                return false;
            }
        } else if (!valorPago.equals(other.valorPago)) {
            return false;
        }
        if (dataDePagamento == null) {
            return other.dataDePagamento == null;
        } else return dataDePagamento.equals(other.dataDePagamento);
    }

}
