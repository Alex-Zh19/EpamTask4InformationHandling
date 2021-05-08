package com.epam.task4.parser.impl;

import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.impl.DelimiterLeaf;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.validator.ExpressionValidator;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParseSentenceToWord implements Parser {
    private Parser parser = new ParseWordToSymbol();
    private final String SPLIT_SENTENCE_TO_WORD = "[\\s]";

    @Override
    public void parse(String str, Component paragraphComposite) {
        Component sentenceComposite = new TextComposite();
        sentenceComposite.setType("sentence");
        Character delimiterSymbol=str.charAt(str.length()-1);
        System.out.println(delimiterSymbol);
        DelimiterLeaf delimiterLeaf=new DelimiterLeaf(Delimiter.getDelimiter(delimiterSymbol.toString()));
        sentenceComposite.add(delimiterLeaf);
        paragraphComposite.add(sentenceComposite);

        String[] strings = str.split(SPLIT_SENTENCE_TO_WORD);
        List<String> words = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                words.add(bufferString);
            }
        }
        while (!words.isEmpty()) {
            String word = words.get(0).trim();
            nextChain(word, sentenceComposite);
            words.remove(0);
        }
    }

    @Override
    public void nextChain(String str, Component component) {
        parser.parse(str, component);
    }
}
