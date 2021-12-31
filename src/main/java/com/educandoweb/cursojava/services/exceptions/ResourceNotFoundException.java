package com.educandoweb.cursojava.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource não encontrado. Id: " + id);
    }
}
