package org.kata.fizz_buzz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.kata.fizz_buzz.FizzBuzz.BUZZ;
import static org.kata.fizz_buzz.FizzBuzz.FIZZ;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    private final FizzBuzz underTest = new FizzBuzz();

    @Test
    void shouldBuildCorrectFizzBuzz() {
        assertThat(underTest.buildFizzBuzzList(15)).containsExactly("1", "2", FIZZ, "4", BUZZ, FIZZ, "7", "8", FIZZ, BUZZ, "11", FIZZ, "13", "14", FIZZ + BUZZ);
    }

    @Test
    void shouldBuildEmptyListByNegativeSize() {
        assertThat(underTest.buildFizzBuzzList(-10)).isEmpty();
    }
}
