package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParseTextToParagraph implements Parser {
    private Parser parser = new ParseParagraphToSentence();
    private String SPLIT_TEXT_TO_PARAGRAPH = "^[\\t]||[ ]{4}||[ ]{8}";

    @Override
    public void parse(String str) {
        String[] strings = str.split(SPLIT_TEXT_TO_PARAGRAPH);
        List<String> paragraphs = new ArrayList<>();
        for (String bufferString : strings) {
            paragraphs.add(bufferString);
        }
        System.out.println(strings.length);
        for (String s:strings){
        System.out.println(s);
        }
        /*
        while (!paragraphs.isEmpty()) {
            String paragraph = paragraphs.get(paragraphs.size() - 1);
            System.out.println(this.getClass());
            nextChain(paragraph);
            paragraphs.remove(paragraphs.size() - 1);
        }*/
    }

    private void nextChain(String str) {
        parser.parse(str);
    }
}
