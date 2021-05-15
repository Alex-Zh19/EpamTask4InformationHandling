package com.epam.task4.main;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.composite.interpreter.ExpressionInterpreter;
import com.epam.task4.composite.interpreter.MathExpression;
import com.epam.task4.composite.interpreter.parser.ExpressionParser;
import com.epam.task4.composite.interpreter.parser.PolishNotationParser;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.parser.impl.ParseTextToParagraph;
import com.epam.task4.reader.CustomReader;
import com.epam.task4.reader.impl.TextReader;

import java.io.File;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InformationHandlingException{
       String PATH_TO_FILE = "data/text.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader = new TextReader();
        Component baseComposite = new TextComposite();
        baseComposite.setType("base");
        try {
            String r = reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
            Parser parser = new ParseTextToParagraph();
            parser.parse(r, baseComposite);
            baseComposite.operation();
        } catch (InformationHandlingException e) {
        }
       /* String expression="(7^5|1&2<<(2|5>>2&71))|1200";
        ExpressionParser parser = new ExpressionParser();
        String expressionPolishNotation = parser.parseStringExpressionToReversPolishNotation(expression);
        System.out.println(expressionPolishNotation);
        PolishNotationParser polishNotationParser = new PolishNotationParser();
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        List<MathExpression> mathExpressions=polishNotationParser.parse(expressionPolishNotation);
        Integer expressionInt = interpreter.interpretExpressionToInteger(mathExpressions);
        System.out.println(expressionInt);*/

    }
}

