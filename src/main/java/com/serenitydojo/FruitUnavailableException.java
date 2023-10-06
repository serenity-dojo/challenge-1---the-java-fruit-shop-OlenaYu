package com.serenitydojo;

public class FruitUnavailableException extends RuntimeException{

    public FruitUnavailableException(String message){
        super(message);
        System.out.println(super.getMessage());
    }

}
