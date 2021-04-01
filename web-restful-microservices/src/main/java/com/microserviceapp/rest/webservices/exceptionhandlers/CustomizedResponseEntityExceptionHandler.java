package com.microserviceapp.rest.webservices.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionGlobalResponse exceptionGlobalResponse = new ExceptionGlobalResponse(LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false));

        return (new ResponseEntity(exceptionGlobalResponse, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionGlobalResponse exceptionGlobalResponse = new ExceptionGlobalResponse(LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false));

        return (new ResponseEntity(exceptionGlobalResponse, HttpStatus.NOT_FOUND));
    }


}
