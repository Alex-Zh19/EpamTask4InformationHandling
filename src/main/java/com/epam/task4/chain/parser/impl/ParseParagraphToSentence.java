package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseParagraphToSentence implements Parser {
    private Parser parser = new ParseSentenceToWord();

    @Override
    public void parse(String str) {
        System.out.println(this.getClass());
        nextChain( str);
    }

    private void nextChain(String str) {
        parser.parse( str);
    }
}
