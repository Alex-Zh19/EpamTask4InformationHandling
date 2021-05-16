package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.impl.SymbolLeaf;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParseParagraphToSentence implements Parser {
    private Parser nextParser = new ParseSentenceToWord();
    private final String SPLIT_PARAGRAPH_TO_SENTENCE = "[.]{1,3}|[!]|[?]";

    @Override
    public void parse(String str, Component textComposite) throws InformationHandlingException {
        String[] strings = str.split(SPLIT_PARAGRAPH_TO_SENTENCE);
        int lengthToFindDelimiter = 0;
        Character delimiter;
        List<String> sentences = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                lengthToFindDelimiter += bufferString.length();
                delimiter = str.charAt(lengthToFindDelimiter);
                StringBuilder buff = new StringBuilder(bufferString);
                buff.append(delimiter);
                sentences.add(buff.toString().trim());
            }
            lengthToFindDelimiter++;
        }
        Component paragraphComposite = new TextComposite();
        paragraphComposite.setType(ComponentType.PARAGRAPH);
        textComposite.add(paragraphComposite);
        SymbolLeaf tab = new SymbolLeaf("    ");//should be here or not
        paragraphComposite.add(tab);//same question
        while (!sentences.isEmpty()) {
            String sentence = sentences.get(0).trim();
            nextChain(sentence, paragraphComposite,nextParser);
            sentences.remove(0);
        }
    }


}
