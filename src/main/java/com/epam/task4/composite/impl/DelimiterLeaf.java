package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.Delimiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DelimiterLeaf implements Component {
    private ComponentType componentType;
    private Delimiter delimiter;
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void operation() {
        //logger.log(Level.INFO,delimiter);
        System.out.print(delimiter);
    }

    @Override
    public List<Component> getComponents() {
        throw new UnsupportedOperationException();
    }

    public DelimiterLeaf(Delimiter delimiter, ComponentType  componentType) {
        this.componentType=componentType;
        this.delimiter = delimiter;
    }

    @Override
    public boolean add(Component component) {
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
    public void setComponents(List<Component> components) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSizeOfComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setType(ComponentType type) {
        this.componentType=type;
    }
}
