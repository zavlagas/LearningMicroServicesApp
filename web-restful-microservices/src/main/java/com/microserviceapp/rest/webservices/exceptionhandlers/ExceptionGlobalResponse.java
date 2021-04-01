package com.microserviceapp.rest.webservices.exceptionhandlers;

import java.time.LocalDate;


public class ExceptionGlobalResponse {

    private final LocalDate timestamp;
    private final String message;
    private final String details;

    public ExceptionGlobalResponse(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
