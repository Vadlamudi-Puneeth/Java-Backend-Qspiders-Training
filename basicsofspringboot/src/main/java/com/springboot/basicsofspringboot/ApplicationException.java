package com.springboot.basicsofspringboot;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {

    @ExceptionHandler(Exception.class)
    public String handleException() {
    	return "Not a valid page";
    }
	
}
