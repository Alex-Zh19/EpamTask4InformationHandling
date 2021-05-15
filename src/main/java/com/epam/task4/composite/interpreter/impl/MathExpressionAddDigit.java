package com.epam.task4.composite.interpreter.impl;

import com.epam.task4.composite.interpreter.ExpressionContext;
import com.epam.task4.composite.interpreter.MathExpression;

public class MathExpressionAddDigit implements MathExpression {
    private int number;

    public MathExpressionAddDigit(int number){
        this.number=number;
    }

    @Override
    public void interpret(ExpressionContext context) {
        context.push(number);
    }
}
