package org.example.service;

import org.example.exception.RegraNegocioException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxaServiceTest {

    private final TaxaService taxaService = new TaxaService();

    @Test
    void deveCalcularTaxaMesmoDia() {
        BigDecimal taxa = taxaService.calcularTaxa(0, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("28.00")));
    }

    @Test
    void deveCalcularTaxaEntre1e10Dias() {
        BigDecimal taxa = taxaService.calcularTaxa(5, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("12.00")));
    }

    @Test
    void deveCalcularTaxaEntre11e20Dias() {
        BigDecimal taxa = taxaService.calcularTaxa(15, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("82.00")));
    }

    @Test
    void deveCalcularTaxaEntre21e30Dias() {
        BigDecimal taxa = taxaService.calcularTaxa(30, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("69.00")));
    }

    @Test
    void deveCalcularTaxaEntre31e40Dias() {
        BigDecimal taxa = taxaService.calcularTaxa(35, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("47.00")));
    }

    @Test
    void deveCalcularTaxaEntre41e50Dias() {
        BigDecimal taxa = taxaService.calcularTaxa(50, new BigDecimal("1000.00"));
        assertEquals(0, taxa.compareTo(new BigDecimal("17.00")));
    }
}