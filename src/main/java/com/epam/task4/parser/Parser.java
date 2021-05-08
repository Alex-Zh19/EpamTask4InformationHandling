package com.epam.task4.parser;

import com.epam.task4.composite.Component;

public interface Parser {
    void parse(String str, Component component);
    void nextChain(String str,Component component);
}
