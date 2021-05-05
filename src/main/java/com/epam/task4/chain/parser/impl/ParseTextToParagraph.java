package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseTextToParagraph implements Parser {
    Parser parser=new ParseParagraphToSentence();
    @Override
    public void nextChain(Parser parser) {

    }

    @Override
    public void parse() {

    }
}
