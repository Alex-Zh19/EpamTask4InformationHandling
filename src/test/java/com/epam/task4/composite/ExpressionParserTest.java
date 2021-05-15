package com.epam.task4.composite;

import com.epam.task4.composite.interpreter.ExpressionParser;
import com.epam.task4.exception.InformationHandlingException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExpressionParserTest {

    @Test
    public void testParseStringExpressionToReversPolishNotation()throws InformationHandlingException {
        String expression="~6&9|(3&4)";
        ExpressionParser parser=new ExpressionParser();
        String polishNotationActual=parser.parseStringExpressionToReversPolishNotation(expression);
        String polishNotationExpected="6934&|&~";
        assertEquals(polishNotationActual,polishNotationExpected);
    }

    @Test
    public void testTestParseStringExpressionToReversPolishNotation() {
    }
}