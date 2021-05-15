package com.epam.task4.composite.interpreter.impl;

import com.epam.task4.composite.interpreter.ExpressionContext;
import com.epam.task4.composite.interpreter.MathExpression;

public class MathExpressionInverting implements MathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.push(~context.pop());
    }
}