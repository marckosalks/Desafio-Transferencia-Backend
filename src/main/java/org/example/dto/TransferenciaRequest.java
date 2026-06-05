package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class TransferenciaRequest {
    @NotBlank(message = "Conta é obrigatória")
    @Size(min = 10, max = 10, message = "Conta inválida!")
    @Pattern(regexp = "^\\d{8}-\\d$", message = "Conta fora do padrão 00000000-0")
    private String contaOrigem;

    @NotBlank(message = "Conta é obrigatória")
    @Size(min = 10, max = 10, message = "Conta inválida!")
    @Pattern(regexp = "^\\d{8}-\\d$", message = "Conta fora do padrão 00000000-0")
    private String contaDestino;

    @NotNull(message = "Valor é obrigatório!")
    private BigDecimal valorTransferencia;

    @NotNull(message = "Data de Transferência obrigatória!")
    private LocalDate dataTransferencia;

}
