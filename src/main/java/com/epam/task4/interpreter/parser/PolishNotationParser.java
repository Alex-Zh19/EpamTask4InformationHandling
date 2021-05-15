package com.epam.task4.interpreter.parser;

import com.epam.task4.interpreter.MathExpression;
import com.epam.task4.interpreter.operation.MathOperation;
import com.epam.task4.interpreter.impl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishNotationParser {
    private static final String SPLIT_EXPRESSION = "\s";

    public List<MathExpression> parse(String polishNotation) {
        return parseLogic(polishNotation);
    }

    private List<MathExpression> parseLogic(String polishNotation) {
        ArrayList<MathExpression> expressions = new ArrayList<>();
        Arrays.asList(polishNotation.split(SPLIT_EXPRESSION)).forEach(symbol -> {
            if (!symbol.isBlank()) {
                switch (symbol.trim()) {
                    case MathOperation.INVERTING:
                        expressions.add(new MathExpressionInverting());
                        break;
                    case MathOperation.PLUS:
                        expressions.add(new MathExpressionPlus());
                        break;
                    case MathOperation.MINUS:
                        expressions.add(new MathExpressionMinus());
                        break;
                    case MathOperation.MULTIPLICATION:
                        expressions.add(new MathExpressionMultiply());
                        break;
                    case MathOperation.DIVISION:
                        expressions.add(new MathExpressionDivide());
                        break;
                    case MathOperation.AND:
                        expressions.add(new MathExpressionAnd());
                        break;
                    case MathOperation.OR:
                        expressions.add(new MathExpressionOr());
                        break;
                    case MathOperation.XOR:
                        expressions.add(new MathExpressionXor());
                        break;
                    case MathOperation.RIGHT_SHIFT:
                        expressions.add(new MathExpressionRightShift());
                        break;
                    case MathOperation.LEFT_SHIFT:
                        expressions.add(new MathExpressionLeftShift());
                        break;
                    default:
                        expressions.add(new MathExpressionAddDigit(Integer.parseInt(symbol)));
                }
            }
        });
        return expressions;
    }
}
