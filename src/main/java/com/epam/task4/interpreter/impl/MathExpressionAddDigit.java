package com.epam.task4.interpreter.impl;

import com.epam.task4.interpreter.ExpressionContext;
import com.epam.task4.interpreter.MathExpression;

public class MathExpressionAddDigit implements MathExpression {
    private int number;

    public MathExpressionAddDigit(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ExpressionContext context) {
        context.push(number);
    }
}
