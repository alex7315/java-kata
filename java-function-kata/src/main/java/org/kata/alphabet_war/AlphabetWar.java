package org.kata.alphabet_war;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class AlphabetWar 
{

    private static final char                 BOMB_CHAR                = '*';
    public static final String                RIGHT_SIDE_WIN_RESULT    = "Right side wins!";
    public static final String                LEFT_SIDE_WIN_RESULT     = "Left side wins!";
    public static final String                TIE_RESULT               = "Let's fight again!";
    private static final Map<String, Integer> LEFT_SIDE_LETTERS_POWER  = Map.of("w", 4, "p", 3, "b", 2, "s", 1);
    private static final Map<String, Integer> RIGHT_SIDE_LETTERS_POWER = Map.of("m", 4, "q", 3, "d", 2, "z", 1);

    public String startBattle(final String fight) {
        if (fight == null || fight.isEmpty()) {
            return TIE_RESULT;
        }

        final List<Integer> bombAndDeathPoitions = new ArrayList<>();
        for (int i = 0; i < fight.length(); i++) {
            if (fight.charAt(i) == BOMB_CHAR) {
                bombAndDeathPoitions.add(i);
                bombAndDeathPoitions.add(i - 1);
                bombAndDeathPoitions.add(i + 1);
            }

        }

        final List<String> resultCharList = new ArrayList<>();
        for (int i = 0; i < fight.length(); i++) {
            if (!bombAndDeathPoitions.contains(i)) {
                resultCharList.add(String.valueOf(fight.charAt(i)));
            }
        }

        Integer leftPower = calculatePower(resultCharList, LEFT_SIDE_LETTERS_POWER);
        Integer rightPower = calculatePower(resultCharList, RIGHT_SIDE_LETTERS_POWER);

        if (leftPower.equals(rightPower)) {
            return TIE_RESULT;
        } else if (leftPower > rightPower) {
            return LEFT_SIDE_WIN_RESULT;
        } else {
            return RIGHT_SIDE_WIN_RESULT;
        }
    }

    private Integer calculatePower(List<String> resultList, Map<String, Integer> powerMap) {
        //@formatter:off
        return resultList
                .stream()
                .map(powerMap::get)
                .filter(Objects::nonNull)
                .reduce(0, (p1, p2) -> p1 + p2);
        //@formatter:on
    }
}
