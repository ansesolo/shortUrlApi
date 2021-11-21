package com.gmail.alf.miniapi.exceptions;

/**
 * Personalized exception to facilitate the error management.
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String entityName, Long id){
        this(entityName, "id", id);
    }

    public ResourceNotFoundException(String entityName, String field, Object value){
        super(String.format("Entity %s not found with %s %s", entityName, field, value));
    }

}
