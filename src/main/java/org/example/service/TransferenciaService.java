package org.example.service;

import org.example.dto.TransferenciaRequest;
import org.example.exception.RegraNegocioException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransferenciaService {

    private static final int LIMITE_DIAS_AGENDAMENTO = 50;

    public String cadastrarAgendamento(TransferenciaRequest dadosTransferencia) {

        LocalDate hoje = LocalDate.now();
        LocalDate dataTransferencia = dadosTransferencia.getDataTransferencia();

        if (dataTransferencia.isBefore(hoje)) {
            throw new RegraNegocioException(
                    "Data da transferência anterior à data atual!"
            );
        }

        long diasParaTransferencia = ChronoUnit.DAYS.between(hoje, dataTransferencia);

        if (diasParaTransferencia > LIMITE_DIAS_AGENDAMENTO) {
            throw new RegraNegocioException(
                    "Não existe taxa aplicável para o período informado!"
            );
        }

        return "Transferência agendada com sucesso";
    }
}