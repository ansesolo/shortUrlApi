package com.gmail.alf.miniapi.exceptions;

/**
 * Personalized exception to facilitate the error management.
 */
public class ResourceIntegrityException extends RuntimeException{

    public ResourceIntegrityException(Object entity){
        super(String.format("Integrity exception during creation of %s", entity.toString()));
    }

}
