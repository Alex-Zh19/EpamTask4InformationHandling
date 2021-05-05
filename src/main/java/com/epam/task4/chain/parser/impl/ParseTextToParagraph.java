package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseTextToParagraph implements Parser {
    private Parser parser = new ParseParagraphToSentence();

    @Override
    public void parse() {
        System.out.println(this.getClass());
        nextChain();
    }

    private void nextChain() {
        parser.parse();
    }
}
