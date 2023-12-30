package org.customer.service.exception;


public class CustomerCreationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CustomerCreationException(String message) {
        super(message);
    }

}
