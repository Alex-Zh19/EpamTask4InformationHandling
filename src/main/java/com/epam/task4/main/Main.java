package com.epam.task4.main;

import com.epam.task4.action.Action;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.impl.DelimiterLeaf;
import com.epam.task4.composite.impl.SymbolLeaf;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.parser.impl.ParseTextToParagraph;
import com.epam.task4.reader.CustomReader;
import com.epam.task4.reader.impl.TextReader;
import com.epam.task4.validator.ExpressionValidator;

import java.io.File;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InformationHandlingException {
        String PATH_TO_FILE = "data/text.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader = new TextReader();
        Component baseComposite = new TextComposite();
        baseComposite.setType(ComponentType.BASE);
        String r = reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
        Parser parser = new ParseTextToParagraph();
        parser.parse(r, baseComposite);
        baseComposite.operation();

        System.out.println();

        List<Component>textComposite=baseComposite.getComponents();
       // System.out.println(textComposite.size());

        Component text=textComposite.get(0);

        Action action=new Action();
        List<Component>sentences=action.findSentencesWithLongestWord(text);
        for(Component sentence:sentences){
            sentence.operation();
            System.out.println();
        }

       // text.operation();
        /*
        String expression="13<<2";
        ExpressionParser parser = new ExpressionParser();
        String expressionPolishNotation = parser.parseStringExpressionToReversPolishNotation(expression);
        System.out.println(expressionPolishNotation);
        PolishNotationParser polishNotationParser = new PolishNotationParser();
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        List<MathExpression> mathExpressions=polishNotationParser.parse(expressionPolishNotation);
        Integer expressionInt = interpreter.interpretExpressionToInteger(mathExpressions);
        System.out.println(expressionInt);

        System.out.println(3>>5);*/

    }
}

