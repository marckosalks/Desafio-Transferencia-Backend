package org.example.exception;

public class TaxaNaoEncontradaException extends RuntimeException {
    public TaxaNaoEncontradaException(String message) {
        super(message);
    }
}
