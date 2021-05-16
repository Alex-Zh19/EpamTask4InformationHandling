package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.impl.DelimiterLeaf;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.composite.impl.SymbolLeaf;

import java.util.ArrayList;
import java.util.List;

public class ParseWordToSymbol implements Parser {
    private final String SPLIT_WORD_TO_SYMBOL = "||";

    @Override
    public void nextChain(String str, Component component,Parser next) throws InformationHandlingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void parse(String str, Component sentenceComposite) throws InformationHandlingException {
        Component wordComposite = new TextComposite();
        wordComposite.setType(ComponentType.WORD);
        SymbolLeaf symbolLeaf = new SymbolLeaf(" ");// should be here or mot
        wordComposite.add(symbolLeaf);//same question
        Character delimiterSymbol = str.charAt(str.length() - 1);
        if (delimiterSymbol.equals(Delimiter.COMMA)) {
            DelimiterLeaf delimiterLeaf = new DelimiterLeaf(Delimiter.COMMA);
            wordComposite.add(delimiterLeaf);
        } else if (delimiterSymbol.equals(Delimiter.DASH)) {
            DelimiterLeaf delimiterLeaf = new DelimiterLeaf(Delimiter.DASH);
            wordComposite.add(delimiterLeaf);
        }

        sentenceComposite.add(wordComposite);
        String[] strings = str.split(SPLIT_WORD_TO_SYMBOL);
        List<String> symbols = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank() && !bufferString.equals(Delimiter.COMMA) && !bufferString.equals(Delimiter.DASH)) {
                symbols.add(bufferString);
            }
        }

        while (!symbols.isEmpty()) {
            Component leaf = new SymbolLeaf(symbols.get(0));
            wordComposite.add(leaf);
            symbols.remove(0);
        }
    }
}
