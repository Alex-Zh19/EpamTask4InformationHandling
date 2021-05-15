package com.epam.task4.interpreter.impl;

import com.epam.task4.interpreter.ExpressionContext;
import com.epam.task4.interpreter.MathExpression;

public class MathExpressionMultiply implements MathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.push(context.pop() * context.pop());
    }
}
