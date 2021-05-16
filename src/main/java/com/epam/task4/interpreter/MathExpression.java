package com.epam.task4.interpreter;

@FunctionalInterface
public interface MathExpression {
    void interpret(ExpressionContext context);
}
