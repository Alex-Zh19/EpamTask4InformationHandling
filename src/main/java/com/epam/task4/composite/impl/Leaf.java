package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;

public class Leaf implements Component {
    private String componentType="symbol";
    private String symbol;


    public Leaf() {

    }

    public Leaf(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public void operation() {
        System.out.println(symbol);
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
    public  void setType(String type){

    }
}
