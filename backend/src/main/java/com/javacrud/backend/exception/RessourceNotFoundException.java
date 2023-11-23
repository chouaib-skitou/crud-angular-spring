package com.javacrud.backend.exception;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public RessourceNotFoundException(String message){
        super(message);
    }

}
