package com.ejemplo.evaluacion.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> validacion(MethodArgumentNotValidException e) {
        List<String> errores = new ArrayList<>();
        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            errores.add(f.getField() + ": " + f.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errores);
    }
}