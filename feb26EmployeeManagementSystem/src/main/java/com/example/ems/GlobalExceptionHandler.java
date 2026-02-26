package com.example.ems;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handle(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}