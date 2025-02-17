package org.kata.test_scrolling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class TextScrollingMachineTest {

    private TextScrollingMachine toTest = new TextScrollingMachine();

    @Test
    void schouldCreateCorrectWordList() {
        assertThat(toTest.scrollText("Hello")).containsExactly("elloH", "lloHe", "loHel", "oHell", "Hello");
    }

}
