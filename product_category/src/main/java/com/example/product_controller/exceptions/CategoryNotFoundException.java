package com.example.product_controller.exceptions;


public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String msg){
        super(msg);
    }
}