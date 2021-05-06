package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.Composite;

import java.util.ArrayList;
import java.util.List;

public class ParseParagraphToSentence implements Parser {
    private Parser parser = new ParseSentenceToWord();
    private final String SPLIT_PARAGRAPH_TO_SENTENCE="[.]{1,3}|[!]|[?]";

    @Override
    public void parse(String str, Component textComposite) {
        String[] strings = str.split(SPLIT_PARAGRAPH_TO_SENTENCE);
        List<String> sentences = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                sentences.add(bufferString);
            }
        }
        Component paragraphComposite = new Composite();
        paragraphComposite.setType("paragraph");
        textComposite.add(paragraphComposite);
        while (!sentences.isEmpty()) {
            String sentence = sentences.get(0);
            System.out.println(this.getClass());
            nextChain(sentence,paragraphComposite);
            sentences.remove(0);
        }
    }

    private void nextChain(String str,Component component) {
        parser.parse(str,component);
    }
}
