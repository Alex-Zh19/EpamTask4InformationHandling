package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseSentenceToWord implements Parser {
    private Parser parser = new ParseWordToSymbol();

    @Override
    public void parse(String str) {
        System.out.println(this.getClass());
        nextChain(str);
    }

    private void nextChain(String str) {
        parser.parse(str);
    }
}
