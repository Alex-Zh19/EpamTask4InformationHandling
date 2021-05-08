package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolLeaf implements Component {
    private String componentType = "symbol";
    private String symbol;
    private static final Logger logger = LogManager.getLogger();


    public SymbolLeaf(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


    @Override
    public void operation() {
        System.out.print(symbol);
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
