package com.epam.task4.interpreter.parser;

import com.epam.task4.interpreter.operation.MathOperation;
import com.epam.task4.exception.InformationHandlingException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ExpressionParser {

    public String parseStringExpressionToReversPolishNotation(String expression) throws InformationHandlingException {
        return toPolishNotation(expression);
    }


    private String toPolishNotation(String expression) throws InformationHandlingException {
        StringBuilder polishNotation = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        String[] allSymbols = split(expression);
        boolean mark = false;
        for (String symbol : allSymbols) {
            if (!symbol.isBlank()) {
                if (isDigit(symbol)) {
                    polishNotation.append(symbol);
                    polishNotation.append(" ");
                    if (mark) {
                        polishNotation.append(MathOperation.INVERTING);
                        polishNotation.append(" ");
                        mark = false;
                    }
                } else if (symbol.equals(MathOperation.INVERTING)) {
                    mark = true;
                } else if (isOperator(symbol)) {
                    stack.add(symbol);
                } else if (symbol.equals(MathOperation.CLOSE_BRACKET)) {
                    String stackSymbol = stack.pollLast();
                    while (!stackSymbol.equals(MathOperation.OPEN_BRACKET)) {
                        polishNotation.append(stackSymbol).append(" ");
                        stackSymbol = stack.pollLast();
                    }
                } else {
                    throw new InformationHandlingException("wrong data in \"expression\": " + expression);
                }
            }

        }
        String stackSymbol = stack.pollLast();
        while (stackSymbol != null) {
            polishNotation.append(stackSymbol).append(" ");
            stackSymbol = stack.pollLast();
        }
        return polishNotation.toString();
    }

    private String[] split(String expression) {
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            symbol.append(expression.charAt(i));
            if (symbol.toString().equals("<") || symbol.toString().equals(">")) {
                continue;
            }
            if (isOperator(symbol.toString()) || symbol.toString().equals(MathOperation.CLOSE_BRACKET)) {
                if (!number.isEmpty()) {
                    strings.add(number.toString());
                    number.delete(0, number.length());
                }
                strings.add(symbol.toString());
            } else if (i == expression.length() - 1) {
                if (!symbol.isEmpty() && isDigit(symbol.toString())) {
                    number.append(symbol);
                }
                strings.add(number.toString());
            } else if (isDigit(symbol.toString())) {
                number.append(symbol);
            }
            symbol.delete(0, symbol.length());
        }
        return strings.toArray(String[]::new);
    }

    private boolean isOperator(String symbol) {
        if (symbol.equals(MathOperation.PLUS) || symbol.equals(MathOperation.MINUS) ||
                symbol.equals(MathOperation.MULTIPLICATION) || symbol.equals(MathOperation.DIVISION) ||
                symbol.equals(MathOperation.OR) || symbol.equals(MathOperation.AND) || symbol.equals(MathOperation.XOR) ||
                symbol.equals(MathOperation.LEFT_SHIFT) || symbol.equals(MathOperation.RIGHT_SHIFT) ||
                symbol.equals(MathOperation.OPEN_BRACKET) || symbol.equals(MathOperation.INVERTING)) {
            return true;
        }
        return false;
    }

    private boolean isDigit(String symbol) {
        Character symb = symbol.charAt(0);
        if (Character.isDigit(symb)) {
            return true;
        }
        return false;
    }


}
