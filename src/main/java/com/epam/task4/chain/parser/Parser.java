package com.epam.task4.chain.parser;

import com.epam.task4.composite.Component;

public interface Parser {
    void parse(String str, Component component);
}
