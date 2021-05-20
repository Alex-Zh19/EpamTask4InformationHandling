package com.epam.task4.interpreter;

import com.epam.task4.parser.PolishNotationParser;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ExpressionInterpreterTest {

    @Test
    public void testInterpretExpressionToInteger() {
        String expressionPolishNotation="6 ~ 9 3 4 & | & ";
        PolishNotationParser polishNotationParser = new PolishNotationParser();
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        List<MathExpression> mathExpressions=polishNotationParser.parse(expressionPolishNotation);
        int actualResult= interpreter.interpretExpressionToInteger(mathExpressions);
        int expectedResult=~6&9|(3&4);
        assertEquals(actualResult,expectedResult);
    }
}