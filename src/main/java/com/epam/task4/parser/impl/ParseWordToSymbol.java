package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.impl.DelimiterLeaf;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.composite.impl.SymbolLeaf;
import com.epam.task4.validator.ExpressionValidator;

import java.util.ArrayList;
import java.util.List;

public class ParseWordToSymbol implements Parser {
    private final String SPLIT_WORD_TO_SYMBOL = "||";

    @Override
    public void nextChain(String str, Component component, Parser next) throws InformationHandlingException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void parse(String str, Component sentenceComposite) throws InformationHandlingException {
        Component wordComposite = new TextComposite();
        wordComposite.setType(ComponentType.WORD);

        SymbolLeaf symbolLeaf = new SymbolLeaf(" ");// should be here or mot
        wordComposite.add(symbolLeaf);//same question

        sentenceComposite.add(wordComposite);

        String[] strings = str.split(SPLIT_WORD_TO_SYMBOL);
        List<String> symbols = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                symbols.add(bufferString);
            }
        }

        while (!symbols.isEmpty()) {
            String symbol = symbols.get(0);
            if (ExpressionValidator.isWordDelimiter(symbol)) {
                delimiterLeafCreating(symbol, wordComposite);
            } else {
                Component leaf = new SymbolLeaf(symbol);
                wordComposite.add(leaf);
            }
            symbols.remove(0);
        }
    }


    private void delimiterLeafCreating(String delimiterSymbol, Component wordComposite) throws InformationHandlingException {
        if (!ExpressionValidator.isWordDelimiter(delimiterSymbol)) {
            return;
        }
        if (delimiterSymbol.equals(Delimiter.COMMA.getValue())) {
            DelimiterLeaf delimiterLeaf = new DelimiterLeaf(Delimiter.COMMA);
            wordComposite.add(delimiterLeaf);
        } else if (delimiterSymbol.equals(Delimiter.DASH.getValue())) {
            DelimiterLeaf delimiterLeaf = new DelimiterLeaf(Delimiter.DASH);
            wordComposite.add(delimiterLeaf);
        } else {
            throw new InformationHandlingException("Symbol isn't a delimiter: " + delimiterSymbol);
        }
    }

}
