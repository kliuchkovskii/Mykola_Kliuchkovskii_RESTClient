package com.epam.lab.utils;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class CustomMapperException extends RuntimeException{

    private String message;

    public CustomMapperException(String message){
        super(message);
        this.message = message;
    }

    public CustomMapperException(){
    }

    public String getMessage(){
        return message;
    }
}
