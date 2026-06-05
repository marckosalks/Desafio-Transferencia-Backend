package org.example.service;

import org.example.dto.TransferenciaRequest;
import org.example.entity.Transferencia;
import org.example.exception.RegraNegocioException;
import org.example.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    private static final int LIMITE_DIAS_AGENDAMENTO = 50;

    private final TransferenciaRepository repository;
    private final TaxaService taxaService;

    public TransferenciaService(
            TransferenciaRepository repository,
            TaxaService taxaService) {
        this.repository = repository;
        this.taxaService = taxaService;
    }

    public Transferencia cadastrarAgendamento(TransferenciaRequest dados) {

        LocalDate hoje = LocalDate.now();
        LocalDate dataTransferencia = dados.getDataTransferencia();

        if (dataTransferencia.isBefore(hoje)) {
            throw new RegraNegocioException("Data da transferência anterior à data atual!");
        }

        if (dados.getValorTransferencia().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            throw new RegraNegocioException("Valor da transferência deve ser maior que zero!");
        }

        long dias = ChronoUnit.DAYS.between(hoje, dataTransferencia);

        if (dias > LIMITE_DIAS_AGENDAMENTO) {
            throw new RegraNegocioException("Não existe taxa aplicável para o período informado!");
        }

        var taxa = taxaService.calcularTaxa(dias, dados.getValorTransferencia());
        var totalTransferencia = taxa.add(dados.getValorTransferencia());
        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem(dados.getContaOrigem());
        transferencia.setContaDestino(dados.getContaDestino());
        transferencia.setValorTransferencia(dados.getValorTransferencia());
        transferencia.setValorTaxa(taxa);
        transferencia.setValorTotalTransferencia(totalTransferencia);
        transferencia.setDataTransferencia(dataTransferencia);
        transferencia.setDataAgendamento(hoje);

        return repository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }
}