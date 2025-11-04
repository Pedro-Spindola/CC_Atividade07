package com.lp7.atividade07.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    /*
    @ExceptionHandler(CampoObrigatorioNuloException.class)
    public ResponseEntity<ErroResponse> handleProdutoNullException(CampoObrigatorioNuloException ex){
        ErroResponse error = new ErroResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }*/
}
