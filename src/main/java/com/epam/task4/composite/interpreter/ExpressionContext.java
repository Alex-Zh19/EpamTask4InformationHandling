package com.epam.task4.composite.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionContext {
    private Deque<Integer> value = new ArrayDeque<>();

    public void push(Integer number) {
        value.push(number);
    }

    public Integer pop() {
        return value.pop();
    }
}
