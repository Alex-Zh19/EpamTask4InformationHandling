package com.epam.task4.composite.interpreter.impl;

import com.epam.task4.composite.interpreter.ExpressionContext;
import com.epam.task4.composite.interpreter.MathExpression;

public class MathExpressionDivide implements MathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.push((int)((double)1/context.pop()*context.pop()));
    }
}
