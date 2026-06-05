package org.example.service;

import org.example.dto.TransferenciaRequest;
import org.example.entity.Transferencia;
import org.example.exception.RegraNegocioException;
import org.example.repository.TransferenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransferenciaServiceTest {

    @Mock
    private TransferenciaRepository repository;

    @Mock
    private TaxaService taxaService;

    private TransferenciaService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new TransferenciaService(repository, taxaService);
    }

    @Test
    void deveCadastrarTransferencia() {

        TransferenciaRequest request =
                TransferenciaRequest.builder()
                        .contaOrigem("12345678-1")
                        .contaDestino("87654321-1")
                        .valorTransferencia(new BigDecimal("1000"))
                        .dataTransferencia(LocalDate.now().plusDays(5))
                        .build();

        when(taxaService.calcularTaxa(any(Long.class), any(BigDecimal.class)))
                .thenReturn(new BigDecimal("12"));

        when(repository.save(any(Transferencia.class)))
                .thenAnswer(i -> i.getArgument(0));

        var response = service.cadastrarAgendamento(request);

        assertNotNull(response);
        assertEquals(new BigDecimal("12"), response.getValorTaxa());
    }

    @Test
    void deveLancarErroQuandoDataForPassada() {

        TransferenciaRequest request =
                TransferenciaRequest.builder()
                        .contaOrigem("12345678-1")
                        .contaDestino("87654321-1")
                        .valorTransferencia(new BigDecimal("1000"))
                        .dataTransferencia(LocalDate.now().minusDays(1))
                        .build();

        assertThrows(
                RegraNegocioException.class,
                () -> service.cadastrarAgendamento(request));
    }
}