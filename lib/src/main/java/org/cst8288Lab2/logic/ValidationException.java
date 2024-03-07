package org.cst8288Lab2.logic;

/**
 * Custom exception class for handling validation errors in the business logic layer.
 * This exception is thrown when data does not meet validation criteria.
 */
public class ValidationException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a ValidationException with a default message indicating invalid data format.
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a ValidationException with a specified detail message about the validation error.
     *
     * @param message The detailed message.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a ValidationException with a specified detail message and cause.
     *
     * @param message The detailed message.
     * @param cause The cause of the exception.
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a ValidationException with a specified cause.
     *
     * @param cause The cause of the exception.
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }
}