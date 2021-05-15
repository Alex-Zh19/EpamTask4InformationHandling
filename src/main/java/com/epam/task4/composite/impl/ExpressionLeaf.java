package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;

public class ExpressionLeaf implements Component {//client
    private String expression;

    public ExpressionLeaf(String expression){
        this.expression=expression;
    }

    @Override
    public void operation() {

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
        return null;
    }

    @Override
    public void setType(String type) {

    }
    public String getExpression(){
        return expression;
    }
}
