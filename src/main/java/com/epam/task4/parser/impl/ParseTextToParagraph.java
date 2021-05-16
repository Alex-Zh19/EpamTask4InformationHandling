package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParseTextToParagraph implements Parser {
    private Parser nextParser = new ParseParagraphToSentence();
    private final String SPLIT_TEXT_TO_PARAGRAPH = "^[\\t]|[ ]{4}|[ ]{8}";

    @Override
    public void parse(String str, Component baseComponent) throws InformationHandlingException {
        String[] strings = str.split(SPLIT_TEXT_TO_PARAGRAPH);
        List<String> paragraphs = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                paragraphs.add(bufferString);
            }
        }
        Component textComposite = new TextComposite();
        textComposite.setType(ComponentType.TEXT);
        baseComponent.add(textComposite);
        while (!paragraphs.isEmpty()) {
            String paragraph = paragraphs.get(0).trim();
            nextChain(paragraph, textComposite,nextParser);
            paragraphs.remove(0);
        }
    }

}
