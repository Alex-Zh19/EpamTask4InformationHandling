package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.Composite;

import java.util.ArrayList;
import java.util.List;

public class ParseSentenceToWord implements Parser {
    private Parser parser = new ParseWordToSymbol();
    private final String SPLIT_SENTENCE_TO_WORD="[\\W]";

    @Override
    public void parse(String str, Component paragraphComposite) {
        String[] strings = str.split(SPLIT_SENTENCE_TO_WORD);
        List<String> words = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                words.add(bufferString);
            }
        }
        Component sentenceComposite = new Composite();
        sentenceComposite.setType("sentence");
        paragraphComposite.add(sentenceComposite);
        while (!words.isEmpty()) {
            String word = words.get(0);
            System.out.println(this.getClass());//delete
            nextChain(word,sentenceComposite);
            words.remove(0);
        }
    }

    private void nextChain(String str, Component component) {
        parser.parse(str,component);
    }
}
