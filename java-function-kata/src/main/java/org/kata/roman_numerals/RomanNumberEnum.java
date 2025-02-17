package org.kata.roman_numerals;

public enum RomanNumberEnum {

    //@formatter:off
    I('I', 1) { //roman number I (decimal 1)

        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return nextNumber.calculateAsNextCharOfI();
        }

        @Override
        ValuePair calculateAsNextCharOfI() {
            return new ValuePair(getValue(), 0);
        }

        @Override
        ValuePair calculateAsNextCharOfX() {
            return new ValuePair(getValue(), 0);
        }

        @Override
        ValuePair calculateAsNextCharOfC() {
            return new ValuePair(getValue(), 0);
        }
    }
    , V('V', 5) { //roman number V (decimal 5) 

        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return new ValuePair(nextNumber.getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //IV (decimal 4) is allowed
            return new ValuePair(getValue() - 1, 1);
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() {
            return new ValuePair(getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() {
            return new ValuePair(getValue(), 0);
        }
    }
    , X('X', 10) { //roman number X (decimal 10)

        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return nextNumber.calculateAsNextCharOfX();
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //IX (decimal 9) is allowed
            return new ValuePair(getValue() - 1, 1);
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() {
            return new ValuePair(getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() {
            return new ValuePair(getValue(), 0);
        }
    }
    , L('L', 50) { //roman number L (decimal 50)  

        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return new ValuePair(nextNumber.getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //IL is semantic error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() { //XL (decimal 40) is allowed
            return new ValuePair(getValue() - 10, 10);
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() {
            return new ValuePair(getValue(), 0);
        }
    }
    , C('C', 100) { //roman number C (decimal 100)

        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) { // CD (decimal 400), CM (decimal 900) can be used
            return nextNumber.calculateAsNextCharOfC();
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //IC is an error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() { //XC (decimal 90)
            return new ValuePair(getValue() - 10, 10);
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() {
            return new ValuePair(getValue(), 0);
        }
    }
    , D('D', 500) { //roman number D (decimal 500)
        
        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return new ValuePair(nextNumber.getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //ID is an error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() { //XD is an error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() { //CD (decimal 400)
            return new ValuePair(getValue() - 100, 100);
        }
    }
    , M('M', 1000) { //roman number M (decimal 1000)
        
        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return new ValuePair(nextNumber.getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() { //IM is an error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() { //XM is an error
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() { //CM (decimal 900)
            return new ValuePair(getValue() - 100, 100);
        }
    }
    , U('U', 0) { //element is user ONLY to define unknown roman number 
        @Override
        ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber) {
            return new ValuePair(nextNumber.getValue(), 0);
        }
        
        @Override
        ValuePair calculateAsNextCharOfI() {
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfX() {
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
        
        @Override
        ValuePair calculateAsNextCharOfC() {
            throw new SemanticErrorException(String.format(ERROR_MESSAGE_TEMPLATE, getCharacter(), getCharacter()));
        }
    };
    
    private static final String ERROR_MESSAGE_TEMPLATE = "%c%c is erroneous ";
    
    //@formatter:on
    private char                character;
    private int                 value;

    RomanNumberEnum(char character, int value) {
        this.character = character;
        this.value = value;
    }

    public char getCharacter() {
        return character;
    }

    public int getValue() {
        return value;
    }

    abstract ValuePair calculateAsPrependChar(RomanNumberEnum nextNumber);

    abstract ValuePair calculateAsNextCharOfI();

    abstract ValuePair calculateAsNextCharOfX();

    abstract ValuePair calculateAsNextCharOfC();

}
