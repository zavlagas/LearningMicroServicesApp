package com.microserviceapp.rest.webservices.exceptionhandlers;

import ch.qos.logback.classic.Logger;
import jdk.jfr.StackTrace;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /*Remove Stack Trace From The Response Request
     * 1) Open application.properties and add the below line:
     * 2) Add server.error.include-stacktrace=never
     *
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
