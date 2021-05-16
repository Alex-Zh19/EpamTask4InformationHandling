package com.epam.task4.parser;

import com.epam.task4.composite.Component;
import com.epam.task4.exception.InformationHandlingException;

public interface Parser {
    void parse(String str, Component component) throws InformationHandlingException;

    default void nextChain(String str, Component component, Parser nextParser) throws InformationHandlingException {
        nextParser.parse(str, component);
    }
}
