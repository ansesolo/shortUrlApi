package com.gmail.alf.miniapi.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String entityName, Long id){
        super(String.format("Entity %s not found with id %d", entityName, id));
    }
}
