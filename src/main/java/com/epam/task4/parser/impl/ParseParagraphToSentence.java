package com.epam.task4.parser.impl;

import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParseParagraphToSentence implements Parser {
    private Parser parser = new ParseSentenceToWord();
    private final String SPLIT_PARAGRAPH_TO_SENTENCE = "[.]{1,3}|[!]|[?]";

    @Override
    public void parse(String str, Component textComposite) {
        String[] strings = str.split(SPLIT_PARAGRAPH_TO_SENTENCE);
        int lengthToFindDelimiter = 0;
        Character delimiter;
        List<String> sentences = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                lengthToFindDelimiter += bufferString.length();
                delimiter = str.charAt(lengthToFindDelimiter);
                StringBuilder buff = new StringBuilder(bufferString);
                buff.append(delimiter);
                sentences.add(buff.toString().trim());
            }
            lengthToFindDelimiter++;
        }
        Component paragraphComposite = new TextComposite();
        paragraphComposite.setType("paragraph");
        textComposite.add(paragraphComposite);
        while (!sentences.isEmpty()) {
            String sentence = sentences.get(0).trim();
            nextChain(sentence, paragraphComposite);
            sentences.remove(0);
        }
    }

    @Override
    public void nextChain(String str, Component component) {
        parser.parse(str, component);
    }
}
