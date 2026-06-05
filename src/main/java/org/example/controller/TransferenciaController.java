package org.example.controller;

import org.example.dto.TransferenciaRequest;
import org.example.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String exibirTransferencias() {
        return "Transferencias: Acompanhar...";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransferenciaRequest cadastrarTransferencia(@RequestBody @Valid TransferenciaRequest dadosTransferencia) {

        transferenciaService.cadastrarAgendamento(dadosTransferencia);
        return dadosTransferencia;

    }
}