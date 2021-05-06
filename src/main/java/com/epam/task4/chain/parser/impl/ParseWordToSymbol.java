package com.epam.task4.chain.parser.impl;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.Composite;
import com.epam.task4.composite.impl.Leaf;

import java.util.ArrayList;
import java.util.List;

public class ParseWordToSymbol implements Parser {
    private final String SPLIT_WORD_TO_SYMBOL="||";
    @Override
    public void parse(String str, Component sentenceComposite) {
        String[] strings = str.split(SPLIT_WORD_TO_SYMBOL);
        List<String> symbols = new ArrayList<>();
        for (String bufferString : strings) {
            if (!bufferString.isBlank()) {
                symbols.add(bufferString);
            }
        }
        Component wordComposite = new Composite();
        wordComposite.setType("word");
        sentenceComposite.add(wordComposite);
        while (!symbols.isEmpty()) {
            System.out.println(this.getClass());//delete
            Component leaf=new Leaf(symbols.get(0));
            wordComposite.add(leaf);
            symbols.remove(0);
        }
    }
}
