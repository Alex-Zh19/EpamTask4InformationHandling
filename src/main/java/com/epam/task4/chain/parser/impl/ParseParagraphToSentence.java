package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseParagraphToSentence implements Parser {
    private Parser parser = new ParseSentenceToWord();

    @Override
    public void parse() {
        System.out.println(this.getClass());
        nextChain();
    }

    private void nextChain() {
        parser.parse();
    }
}
