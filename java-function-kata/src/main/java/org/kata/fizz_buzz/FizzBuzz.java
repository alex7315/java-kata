package org.kata.fizz_buzz;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public List<String> buildFizzBuzzList(int size) {
        if (size < 1) return emptyList();

        //@formatter:off
        return IntStream
                .rangeClosed(1, size)
                .mapToObj(this::mapItem)
                .toList();
        //@formatter:on
    }

    private String mapItem(int item) {
        if (checkFizz(item) && checkBuzz(item)) {
            return FIZZ + BUZZ;
        } else if (checkFizz(item)) {
            return FIZZ;
        } else if (checkBuzz(item)) {
            return BUZZ;
        } else {
            return String.valueOf(item);
        }
    }

    private boolean checkFizz(int item) {
        return item % 3 == 0;
    }

    private boolean checkBuzz(int item) {
        return item % 5 == 0;
    }
}
