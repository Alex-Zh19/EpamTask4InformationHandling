package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;

public class ExpressionLeaf implements Component {
    private String componentType = "expression";
    private String expression;

    @Override
    public void operation() {

    }

    public ExpressionLeaf(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }

    @Override
    public String getType() {
        return componentType;
    }

    @Override
    public void setType(String type) {

    }
}
