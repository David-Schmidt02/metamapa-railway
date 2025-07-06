package ar.edu.utn.frba.ddsi.agregador.middleware;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception e) {
        // Manejo de excepciones genérico
        return ResponseEntity
                .badRequest()
                .body("💥 ERROR: " + e.getMessage());
    }

}
