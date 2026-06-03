package org.example.entity;

import lombok.*;
//expecifico para distribuições da oracle
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transferencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 10)
    String contaOrigem;

    @Column(nullable = false, length = 10)
    String contaDestino;

    @Column(nullable = false, precision = 15, scale = 2)
    BigDecimal valorTransferencia;

    @Column(nullable =  false, precision = 15, scale = 2)
    BigDecimal valorTaxa;

    @Column(nullable = false)
    LocalDate dataTransferencia;

    @Column(nullable = false)
    LocalDate dataAgendamento;
}
