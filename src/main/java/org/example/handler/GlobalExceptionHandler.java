package org.example.handler;

import org.example.dto.TransferenciaError;
import org.example.exception.ContaInvalidaException;
import org.example.exception.DataInvalidaException;
import org.example.exception.TaxaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContaInvalidaException.class)
    public ResponseEntity<TransferenciaError> handleContaInvalida(ContaInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new TransferenciaError(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(DataInvalidaException.class)
    public ResponseEntity<TransferenciaError> handleDataInvalida(DataInvalidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new TransferenciaError(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(TaxaNaoEncontradaException.class)
    public ResponseEntity<TransferenciaError> handleTaxaNaoEncontrada(TaxaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new TransferenciaError(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
