package com.epam.task4.main;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.chain.parser.impl.ParseTextToParagraph;

public class Main {
    public static void main(String[] args) {
        Parser parser=new ParseTextToParagraph();
        parser.parse();
    }
}
