package com.example.pac.exceptions;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public String categoryError(CategoryNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String productError(ProductNotFoundException ex){
        return ex.getMessage();
    }
    
    @ExceptionHandler(Exception.class)
    public String allError(){
        return "page not found";
    }
    
    
    
}