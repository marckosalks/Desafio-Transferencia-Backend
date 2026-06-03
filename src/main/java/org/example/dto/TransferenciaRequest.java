package org.example.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class TransferenciaRequest {

    String contaOrigem;
    String contaDestino;
    BigDecimal valorTransferencia;
    LocalDate dataTransferencia;

}
