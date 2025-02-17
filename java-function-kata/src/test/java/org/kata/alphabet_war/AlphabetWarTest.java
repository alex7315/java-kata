package org.kata.alphabet_war;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AlphabetWarTest {

    private final AlphabetWar toTest = new AlphabetWar();

    @Test
    void schouldGetLeftLetterWin() {
        assertThat(toTest.startBattle("www*www****z")).isEqualTo(AlphabetWar.LEFT_SIDE_WIN_RESULT);
    }
    
    @Test
    void schuldGetRightLetterWin() {
        assertThat(toTest.startBattle("zzzz*s*")).isEqualTo(AlphabetWar.RIGHT_SIDE_WIN_RESULT);
        assertThat(toTest.startBattle("s*zz")).isEqualTo(AlphabetWar.RIGHT_SIDE_WIN_RESULT);
    }
    
    @Test
    void schouldGetTieResult() {
        assertThat(toTest.startBattle("*zd*qm*wp*bs*")).isEqualTo(AlphabetWar.TIE_RESULT);
        assertThat(toTest.startBattle(null)).isEqualTo(AlphabetWar.TIE_RESULT);
        assertThat(toTest.startBattle("")).isEqualTo(AlphabetWar.TIE_RESULT);
        assertThat(toTest.startBattle("    ")).isEqualTo(AlphabetWar.TIE_RESULT);
    }
}
