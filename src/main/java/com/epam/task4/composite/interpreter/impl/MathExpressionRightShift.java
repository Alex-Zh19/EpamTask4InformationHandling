package com.epam.task4.composite.interpreter.impl;

import com.epam.task4.composite.interpreter.ExpressionContext;
import com.epam.task4.composite.interpreter.MathExpression;

public class MathExpressionRightShift implements MathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        Integer integer1=context.pop();
        Integer integer2=context.pop();
        context.push(integer2>>integer1);
    }
}
