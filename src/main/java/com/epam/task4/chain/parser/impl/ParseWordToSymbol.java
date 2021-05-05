package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;

public class ParseWordToSymbol implements Parser {

    @Override
    public void parse() {
        System.out.println(this.getClass());
    }
}
