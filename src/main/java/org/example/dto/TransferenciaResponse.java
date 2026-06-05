package org.example.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransferenciaResponse {

    Long id;
    String contaOrigem;
    String contaDestino;
    BigDecimal valorTransferencia;
    BigDecimal valorTaxa;
    BigDecimal valorTotalTransferencia;
    LocalDate dataTransferencia;
    LocalDateTime dataAgendamento;

}
