package org.kata.roman_numerals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DecimalToRomanNumberParserTest {

    private final DecimalToRomanNumberParser underTest = new DecimalToRomanNumberParser();

    @Test
    void shouldParseCorrectDecimalNumberToRoman() {
        assertThat(underTest.parse(1984)).isEqualTo("MCDLXXXIV");
    }
}
