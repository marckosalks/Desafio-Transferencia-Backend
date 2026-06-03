package org.example.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaResponse {

    Long id;
    String contaOrigem;
    String contaDestino;
    BigDecimal valorTransferencia;
    BigDecimal valorTaxa;
    LocalDate dataTransferencia;
    LocalDate dataAgendamento;

}
