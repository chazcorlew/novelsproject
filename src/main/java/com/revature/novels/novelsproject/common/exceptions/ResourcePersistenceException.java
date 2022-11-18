package com.revature.novels.novelsproject.common.exceptions;

public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException() {
        super("The provided resource could not be persisted.");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }



}
