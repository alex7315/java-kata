package org.kata.test_scrolling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextScrollingMachine {

    public List<String> scrollText(final String word) {
        if (word == null || word.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> resultList = new ArrayList<>();
        String previouseWord = word;
        for (int i = 0; i < word.length(); i++) {
            String currentWord = moveLeter(previouseWord);
            resultList.add(currentWord);
            previouseWord = currentWord;
        }

        return resultList;
    }

    private String moveLeter(final String wordToMove) {
        char[] charArray = new char[wordToMove.length()];
        for (int i = 0; i < wordToMove.length(); i++) {
            if (i > 0) {
                charArray[i - 1] = wordToMove.charAt(i);
            }
        }

        charArray[wordToMove.length() - 1] = wordToMove.charAt(0);
        return String.valueOf(charArray);
    }
}
