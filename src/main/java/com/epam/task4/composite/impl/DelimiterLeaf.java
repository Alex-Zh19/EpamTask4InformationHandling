package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.Delimiter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DelimiterLeaf implements Component {
    private String componentType = "delimiter";
    private Delimiter delimiter;
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void operation() {
        logger.log(Level.INFO, delimiter);
    }

    public DelimiterLeaf(Delimiter delimiter) {
        this.delimiter = delimiter;
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
