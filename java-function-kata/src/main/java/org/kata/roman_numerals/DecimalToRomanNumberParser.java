package org.kata.roman_numerals;

import java.util.Arrays;

public class DecimalToRomanNumberParser {

    private static final String I            = "I";
    private static final String V            = "V";
    private static final String L            = "L";
    private static final String X            = "X";
    private static final String D            = "D";
    private static final String C            = "C";
    private static final String M            = "M";
    private static final String EMPTY_RESULT = "";

    enum DecimalNumberEnum {
        //@formatter:off
        ONE_DIGIT(1)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanOfFirstNumbers(getValue(), onesChar);
            }
        }
        , TWO_DIGIT(2)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanOfFirstNumbers(getValue(), onesChar);
            }
        }
        ,THREE_DIGIT(3)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanOfFirstNumbers(getValue(), onesChar);
            }
        }
        
        , FOUR_DIGIT(4)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return onesChar + fivesChar;
            }
        }
        , FIVE_DIGIT(5)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanNumberOfMiddleNumbers(getValue(), onesChar, fivesChar);
            }
        }
        , SIX_DIGIT(6)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanNumberOfMiddleNumbers(getValue(), onesChar, fivesChar);
            }
        }
        , SEVEN_DIGIT(7)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanNumberOfMiddleNumbers(getValue(), onesChar, fivesChar);
            }
        }
        , EIGHT_DIGIT(8)
        {
            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return createRomanNumberOfMiddleNumbers(getValue(), onesChar, fivesChar);
            }
        }
        , NINE_DIGIT(9)
        {

            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return onesChar + fivesChar;
            }
        },
        ZERO_DIGIT(0) {

            @Override
            String createRomanNumber(String onesChar, String fivesChar, String tensChar) {
                return EMPTY_RESULT;
            }
            
        };

        //@formatter:on
        int value;

        private DecimalNumberEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
        public static DecimalNumberEnum valueOf(int value) {
            return Arrays.asList(DecimalNumberEnum.values()).stream().filter(dn -> value == dn.getValue()).findFirst()
                    .orElseThrow(() -> new SemanticErrorException(String.format("Not expected value %d", value)));
        }

        abstract String createRomanNumber(String onesCharacter, String fivesCharacter, String tensCharacter);

        private static String createRomanNumberOfMiddleNumbers(int value, String onesCharacter, String fivesCharacter) {
            return fivesCharacter + times(value - 5, onesCharacter);
        }

        private static String createRomanOfFirstNumbers(int value, String onesCharacter) {
            return times(value, onesCharacter);
        }

    }

    public String parse(int source) {

        int thousands = source / 1000;
        StringBuilder result = new StringBuilder().append(times(thousands, M));

        int hunderts = source / 100 % 10;
        result.append(DecimalNumberEnum.valueOf(hunderts).createRomanNumber(C, D, M));
        
        int tens = source / 10 % 10;
        result.append(DecimalNumberEnum.valueOf(tens).createRomanNumber(X, L, C));

        int ones = source % 10;
        result.append(DecimalNumberEnum.valueOf(ones).createRomanNumber(I, V, X));

        return result.toString();
    }

    private static String times(int number, String character) {
        StringBuilder resultBuilder = new StringBuilder(EMPTY_RESULT);

        for (int i = 0; i < number; i++) {
            resultBuilder.append(character);
        }
        return resultBuilder.toString();
    }
}
