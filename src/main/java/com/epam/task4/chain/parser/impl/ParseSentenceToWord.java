package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseSentenceToWord implements Parser {
    Parser parser=new ParseWordToSymbol();
    @Override
    public void nextChain(Parser parser) {

    }

    @Override
    public void parse() {

    }
}
