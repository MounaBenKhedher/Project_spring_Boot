package com.example.project.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
import java.sql.SQLException;
import java.time.LocalDateTime;
@Getter
@Setter

@ControllerAdvice
public class BasicController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingEntity.class)
    public ResponseEntity<ExceptionResponse> HandlerMissingEntity(MissingEntity e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(e.getMessage());
        response.setStatus(404);
        response.setTimestamp(LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);
    }

    //verifier le statue inactive ou active
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<ExceptionResponse> HandlerConnectException(ConnectException e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(e.getMessage());
        response.setStatus(500);
        response.setTimestamp(LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);

    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionResponse> HandlerConnectException(SQLException e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(e.getMessage());
        response.setStatus(500);
        response.setTimestamp(LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);


}
    @ExceptionHandler(DuplicateEntity.class)
    public ResponseEntity<ExceptionResponse> HandlerDuplicateEntityException(DuplicateEntity e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(e.getMessage());
        response.setStatus(500);
        response.setTimestamp(LocalDateTime.now());

        return ResponseEntity.badRequest().body(response);


    }
    @ExceptionHandler(CmntEntity.class)
    public ResponseEntity<ExceptionResponse> HandlercmntEntityException(CmntEntity c) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(c.getMessage());
        response.setStatus(500);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);


    }

}