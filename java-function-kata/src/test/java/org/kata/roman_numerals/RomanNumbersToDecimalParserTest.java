package org.kata.roman_numerals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RomanNumbersToDecimalParserTest {

    private final RomanNumbersToDecimalParser underTest = new RomanNumbersToDecimalParser();

    @Test
    void shouldParseCorrectRomanNumbers() {
        assertThat(underTest.parse("MDCCCCLXXXIIII")).isEqualTo(1984);
        assertThat(underTest.parse("MCMLXXXIV")).isEqualTo(1984);
    }

    @Test
    void shouldRecognizeSyntacticError() {
        assertThatThrownBy(() -> underTest.parse("I X")).isInstanceOf(SyntaxErrorException.class);
    }

    @Test
    void shouldRecognizeSemanticError() {
        assertThatThrownBy(() -> underTest.parse("IC")).isInstanceOf(SemanticErrorException.class);
    }
}
