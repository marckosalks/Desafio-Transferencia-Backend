package org.example.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1")
@RestController
public class TransferenciaController {

    @GetMapping("/transferencia")
    @ResponseStatus(HttpStatus.OK)
    public String ExibirTransferencias(){
        return "Transferencias: Acompanhar...";
    }

    @PostMapping("/transferencia")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarTransferencia(){
        return "transferencia realizada com sucesso";
    }
}
