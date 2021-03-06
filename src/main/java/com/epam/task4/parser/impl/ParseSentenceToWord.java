package com.epam.task4.parser.impl;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import com.epam.task4.composite.impl.DelimiterLeaf;
import com.epam.task4.interpreter.ExpressionInterpreter;
import com.epam.task4.interpreter.MathExpression;
import com.epam.task4.parser.ExpressionParser;
import com.epam.task4.parser.PolishNotationParser;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.validator.ExpressionValidator;

import java.util.ArrayList;
import java.util.List;

public class ParseSentenceToWord implements Parser {
    private Parser nextParser = new ParseWordToSymbol();
    private final String SPLIT_SENTENCE_TO_WORD = "[\\s]";

    @Override
    public void parse(String str, Component paragraphComposite) throws InformationHandlingException {
        Component sentenceComposite = new TextComposite();
        sentenceComposite.setType(ComponentType.SENTENCE);

        paragraphComposite.add(sentenceComposite);

        String[] strings = str.split(SPLIT_SENTENCE_TO_WORD);
        List<String> words = new ArrayList<>();
        for (String bufferString : strings) {
            if (ExpressionValidator.validate(bufferString)) {
                ExpressionParser parser = new ExpressionParser();
                String expressionPolishNotation = parser.parseStringExpressionToReversPolishNotation(bufferString);
                PolishNotationParser polishNotationParser = new PolishNotationParser();
                ExpressionInterpreter interpreter = new ExpressionInterpreter();
                List<MathExpression> mathExpressions = polishNotationParser.parse(expressionPolishNotation);
                Integer expression = interpreter.interpretExpressionToInteger(mathExpressions);
                words.add(expression.toString());
            } else if (!bufferString.isBlank()) {
                words.add(bufferString);
            }
        }
        while (!words.isEmpty()) {
            StringBuilder word =new StringBuilder(words.get(0).trim());
            Character delimiterSymbol = word.charAt(word.length() - 1);
            if(ExpressionValidator.isSentenceDelimiter(delimiterSymbol.toString())){
                word.deleteCharAt(word.length()-1);
                DelimiterLeaf delimiterLeaf=new DelimiterLeaf(Delimiter.getDelimiter(delimiterSymbol.toString()),
                        ComponentType.SENTENCE_DELIMITER);
                nextChain(word.toString(), sentenceComposite, nextParser);
                sentenceComposite.add(delimiterLeaf);
            }else{
                nextChain(word.toString(), sentenceComposite, nextParser);
            }
            words.remove(0);
        }
    }



}
