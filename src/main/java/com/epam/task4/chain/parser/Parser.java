package com.epam.task4.chain.parser;

public interface Parser {
    void nextChain(Parser parser);
    void parse();
}
