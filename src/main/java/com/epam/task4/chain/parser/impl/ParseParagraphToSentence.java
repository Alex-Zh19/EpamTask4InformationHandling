package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParseParagraphToSentence implements Parser {
    private Parser parser = new ParseSentenceToWord();
    private final String SPLIT_PARAGRAPH_TO_SENTENCE="[.]{1,3}|[!]|[?]";

    @Override
    public void parse(String str) {
        String[] strings = str.split(SPLIT_PARAGRAPH_TO_SENTENCE);
        List<String> sentences = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                sentences.add(bufferString);
            }
        }

        while (!sentences.isEmpty()) {
            String sentence = sentences.get(sentences.size() - 1);
            System.out.println(this.getClass());
            nextChain(sentence);
            sentences.remove(sentences.size() - 1);
        }
    }

    private void nextChain(String str) {
        parser.parse( str);
    }
}
