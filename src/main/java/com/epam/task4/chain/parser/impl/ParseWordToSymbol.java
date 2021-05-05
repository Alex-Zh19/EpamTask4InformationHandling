package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.Composite;
import com.epam.task4.composite.impl.Leaf;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ParseWordToSymbol implements Parser {
    private final String SPLIT_WORD_TO_SYMBOL="||";
    @Override
    public void parse(String str) {
        String[] strings = str.split(SPLIT_WORD_TO_SYMBOL);
        List<String> symbols = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                symbols.add(bufferString);
            }
        }
        
        Composite composite=new Composite();
        while (!symbols.isEmpty()) {
            System.out.println(this.getClass());
            Component leaf=new Leaf(symbols.get(symbols.size()-1));
            composite.add(leaf);
            symbols.remove(symbols.size() - 1);
        }
    }
}
