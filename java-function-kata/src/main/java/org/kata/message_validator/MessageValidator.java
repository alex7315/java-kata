package org.kata.message_validator;

import static java.lang.Character.isDigit;

import java.util.HashMap;
import java.util.Map;

public class MessageValidator {

    private static final char EMPTY_CHAR = ' ';

    public Boolean validate(String message) {
        Map<Integer, String> parsedMap = parseMessage(message);
        return validateMessage(parsedMap);
    }

    private Boolean validateMessage(Map<Integer, String> parsedMap) {
        //@formatter:off
        return parsedMap
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().intValue() == entry.getValue().length())
                .reduce((v1, v2) -> v1 && v2)
                .orElseGet(() -> Boolean.TRUE );
        //@formatter:on
    }

    private Map<Integer, String> parseMessage(String message) {
        StringBuilder numberBuilder = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        char previouseChar = EMPTY_CHAR;
        Map<Integer, String> result = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            if (isDigit(message.charAt(i))) {
                if (!isDigit(previouseChar) && previouseChar != EMPTY_CHAR) {
                    putToResult(numberBuilder, stringBuilder, result);
                    numberBuilder = new StringBuilder();
                    stringBuilder = new StringBuilder();
                }
                numberBuilder.append(message.charAt(i));
            } else {
                stringBuilder.append(message.charAt(i));
            }
            previouseChar = message.charAt(i);
        }

        return result;
    }

    private void putToResult(final StringBuilder numberBuilder, final StringBuilder stringBuilder, Map<Integer, String> result) {
        try {
            result.put(Integer.parseInt(numberBuilder.toString()), stringBuilder.toString());
        } catch (NumberFormatException e) {
            result.put(0, stringBuilder.toString());
        }
    }

}
