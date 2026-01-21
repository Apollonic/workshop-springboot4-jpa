package com.educandoweb.course.resources.exceptions;

import com.educandoweb.course.services.exceptions.ResouceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResouceExceptionHandler {

    //essa classe serve para atribuir os valores aos atributos da classe StandardError. Ela prepara o objeto!

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (ResouceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
