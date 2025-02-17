package org.kata.roman_numerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumbersToDecimalParser {

    private static final RomanNumberEnum UNKNOWN_ROMAN_MUMBER     = RomanNumberEnum.U;

    //@formatter:off
    private final List<Character> romanNumberCharacterList = Arrays.asList(RomanNumberEnum.values())
                                                                .stream()
                                                                .filter(rn -> !rn.equals(UNKNOWN_ROMAN_MUMBER))
                                                                .map(RomanNumberEnum::getCharacter)
                                                                .toList();
    //@formatter:on

    public int parse(String numbers) {
        
        RomanNumberEnum previousNumber = UNKNOWN_ROMAN_MUMBER;
        int resultValue = 0;
        for (int i = 0; i < numbers.length(); i++) {
            char currentCharacter = numbers.charAt(i);
            if (validateCharacter(currentCharacter)) {
                RomanNumberEnum currentNumber = RomanNumberEnum.valueOf(String.valueOf(currentCharacter));
                ValuePair currentValuePair = previousNumber.calculateAsPrependChar(currentNumber);

                resultValue += currentValuePair.getCalculatedValue();
                resultValue -= currentValuePair.getSubstractionValue();
                previousNumber = currentNumber;
            } else {
                throw new SyntaxErrorException(String.format("invalid roman number: %s", numbers));
            }
        }
        return resultValue;
    }

    private boolean validateCharacter(char character) {
        return romanNumberCharacterList.contains(Character.valueOf(character));
    }

}
