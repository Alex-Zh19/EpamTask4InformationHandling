package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements Component {
    private final ComponentType componentType = ComponentType.SYMBOL;
    private String symbol;


    public SymbolLeaf(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }




    @Override
    public boolean add(Component component) {
       throw new UnsupportedOperationException();
    }

    @Override
    public void setComponents(List<Component> components) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSizeOfComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<Component> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setType(ComponentType type) {

    }

    @Override
    public String toString() {
        return symbol;
    }
}
