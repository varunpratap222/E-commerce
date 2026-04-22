package com.example.EcommerceProject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException ex) {

        String msg = ex.getMessage();

        if (msg.contains("registered")) {
            return ResponseEntity.status(409).body(Map.of(
                    "success", false,
                    "message", msg
            ));
        }

        if (msg.contains("not found") || msg.contains("Invalid")) {
            return ResponseEntity.status(401).body(Map.of(
                    "success", false,
                    "message", msg
            ));
        }

        return ResponseEntity.status(400).body(Map.of(
                "success", false,
                "message", msg
        ));
    }
}