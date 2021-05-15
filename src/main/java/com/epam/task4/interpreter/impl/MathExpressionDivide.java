package com.epam.task4.interpreter.impl;

import com.epam.task4.interpreter.ExpressionContext;
import com.epam.task4.interpreter.MathExpression;

public class MathExpressionDivide implements MathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.push((int)((double)1/context.pop()*context.pop()));
    }
}
