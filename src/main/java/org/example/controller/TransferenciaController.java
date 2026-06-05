package org.example.controller;

import org.example.dto.TransferenciaRequest;
import org.example.entity.Transferencia;
import org.example.repository.TransferenciaRepository;
import org.example.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;
    private final TransferenciaRepository  transferenciaRepository;

    public TransferenciaController(TransferenciaService transferenciaService, TransferenciaRepository transferenciaRepository) {
        this.transferenciaService = transferenciaService;
        this.transferenciaRepository = transferenciaRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transferencia> exibirTransferencias()
    {
        return transferenciaRepository.findAll() ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Transferencia> agendar(@RequestBody @Valid TransferenciaRequest dadosTransferencia) {
        return ResponseEntity.ok(transferenciaService.cadastrarAgendamento(dadosTransferencia));
    }
}