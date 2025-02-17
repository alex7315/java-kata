package org.kata.roman_numerals;


public class SemanticErrorException extends RuntimeException{

    /**
     * 
     */
    private static final long   serialVersionUID = 6669034705722480617L;

    private static final String MESSAGE          = "SEMANTIC ERROR: ";

    public SemanticErrorException(String message, Throwable cause) {
        super(MESSAGE + message, cause);
    }

    public SemanticErrorException(String message) {
        super(MESSAGE + message);
    }

}
