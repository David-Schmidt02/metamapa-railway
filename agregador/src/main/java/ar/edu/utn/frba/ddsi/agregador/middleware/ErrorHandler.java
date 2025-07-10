package ar.edu.utn.frba.ddsi.agregador.middleware;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception e) {
        int statusCode = getStatusFromException(e);
        return ResponseEntity
                .status(statusCode)
                .body("💥 ERROR: " + e.getMessage());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handlerResponseStatusException(ResponseStatusException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body("❌ ERROR: " + e.getReason());
    }

    private int getStatusFromException(Exception e) {
        if (e instanceof ResponseStatusException) {
            return ((ResponseStatusException) e).getStatusCode().value();
        }
        if (e instanceof IllegalArgumentException) {
            return 400;
        }
        return 500;
    }
}