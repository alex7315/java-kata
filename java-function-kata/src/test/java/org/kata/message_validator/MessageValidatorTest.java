package org.kata.message_validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MessageValidatorTest {

    private final MessageValidator toTest = new MessageValidator();

    @Test
    void shouldReturnValidMessage() {
        assertThat(toTest.validate("4code13hellocodewars")).isTrue();
    }

    @Test
    void shouldReturnInvalidMessage() {
        assertThat(toTest.validate("hello5")).isFalse();
    }

    @Test
    void shouldReturnValidByEmptyMessage() {
        assertThat(toTest.validate("")).isTrue();
    }
}
