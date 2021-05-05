package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.composite.impl.Composite;

import java.util.ArrayList;
import java.util.List;

public class ParseSentenceToWord implements Parser {
    private Parser parser = new ParseWordToSymbol();
    private final String SPLIT_SENTENCE_TO_WORD="[\\W]";

    @Override
    public void parse(String str) {
        String[] strings = str.split(SPLIT_SENTENCE_TO_WORD);
        List<String> words = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                words.add(bufferString);
            }
        }

        while (!words.isEmpty()) {
            String word = words.get(words.size() - 1);

            nextChain(word);
            words.remove(words.size() - 1);
        }
    }

    private void nextChain(String str) {
        parser.parse(str);
    }
}
