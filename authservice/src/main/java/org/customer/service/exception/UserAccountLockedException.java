package org.customer.service.exception;

public class UserAccountLockedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAccountLockedException(String message) {
        super(message);
    }
}
