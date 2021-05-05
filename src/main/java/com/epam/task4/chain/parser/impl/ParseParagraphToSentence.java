package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseParagraphToSentence implements Parser {
    Parser parser=new ParseSentenceToWord();
    @Override
    public void nextChain(Parser parser) {

    }

    @Override
    public void parse() {

    }
}
