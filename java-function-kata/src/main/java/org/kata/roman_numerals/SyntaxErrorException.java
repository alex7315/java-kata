package org.kata.roman_numerals;


public class SyntaxErrorException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 5843955595727801675L;
    
    private static final String MESSAGE          = "SYNTAX ERROR: ";

    public SyntaxErrorException(String message, Throwable cause) {
        super(MESSAGE + message, cause);
    }

    public SyntaxErrorException(String message) {
        super(MESSAGE + message);
    }

}
