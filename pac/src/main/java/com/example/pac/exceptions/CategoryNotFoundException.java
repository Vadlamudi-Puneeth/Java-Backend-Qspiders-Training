package com.example.pac.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String msg){
        super(msg);
    }
}