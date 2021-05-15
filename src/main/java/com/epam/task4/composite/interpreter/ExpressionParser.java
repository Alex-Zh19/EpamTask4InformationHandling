package com.epam.task4.composite.interpreter;

import com.epam.task4.composite.impl.ExpressionLeaf;
import com.epam.task4.exception.InformationHandlingException;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionParser {
    private static final String SPLIT_WORD_TO_SYMBOL = "||";

    public String parseStringExpressionToReversPolishNotation(String expression) throws InformationHandlingException {
        return toPolishNotation(expression);
    }

    public ExpressionLeaf parseStringExpressionToReversPolishNotation(ExpressionLeaf expressionLeaf) throws InformationHandlingException {
        String expression = expressionLeaf.getExpression();
        String polishNotation=toPolishNotation(expression);
        ExpressionLeaf newExpression = new ExpressionLeaf(polishNotation);
        return newExpression;
    }

    private String toPolishNotation(String expression) throws InformationHandlingException {
        StringBuilder polishNotation = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        String[] allSymbols = expression.split(SPLIT_WORD_TO_SYMBOL);
        for (String symbol : allSymbols) {
            if (!symbol.isBlank()) {
                if (isDigit(symbol)) {
                    polishNotation.append(symbol);
                } else if (symbol.equals(MathOperation.PLUS) || symbol.equals(MathOperation.MINUS) ||
                        symbol.equals(MathOperation.MULTIPLICATION) || symbol.equals(MathOperation.DIVISION) ||
                        symbol.equals(MathOperation.OR) || symbol.equals(MathOperation.AND) || symbol.equals(MathOperation.XOR) ||
                        symbol.equals(MathOperation.LEFT_SHIFT) || symbol.equals(MathOperation.RIGHT_SHIFT) ||
                        symbol.equals(MathOperation.OPEN_BRACKET) || symbol.equals(MathOperation.POBIT_DOPOLENIE)) {
                    stack.add(symbol);
                } else if (symbol.equals(MathOperation.CLOSE_BRACKET)) {
                    String stackSymbol = stack.pollLast();
                    while (!stackSymbol.equals(MathOperation.OPEN_BRACKET)) {
                        polishNotation.append(stackSymbol);
                        stackSymbol = stack.pollLast();
                    }
                } else {
                    throw new InformationHandlingException("wrong data in \"expression\": " + expression);
                }
            }

        }
        String stackSymbol = stack.pollLast();
        while (stackSymbol != null) {
            polishNotation.append(stackSymbol);
            stackSymbol = stack.pollLast();
        }
        return polishNotation.toString();
    }

    private boolean isDigit(String symbol) {
        Character symb = symbol.charAt(0);
        if (Character.isDigit(symb)) {
            return true;
        }
        return false;
    }


}
