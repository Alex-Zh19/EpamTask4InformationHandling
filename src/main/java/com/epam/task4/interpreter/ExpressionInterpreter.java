package com.epam.task4.interpreter;

import java.util.List;

public class ExpressionInterpreter {

    public Integer interpretExpressionToInteger(List<MathExpression> expressions) {
        ExpressionContext context = new ExpressionContext();
        for (MathExpression expression : expressions) {
            expression.interpret(context);
        }
        return context.pop();
    }
}
