package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components = new ArrayList<>();
    private ComponentType componentType;

    @Override
    public void setComponents(List<Component> components) {
        if (components != null) {
            this.components.removeAll(this.components);
            this.components.addAll(components);
        }
    }

    @Override
    public int getSizeOfComponents() {
        int size = 0;
        for (Component component : components) {
            if (!component.getType().equals(ComponentType.SPACE_TAB_DELIMITER) &&
                    !component.getType().equals(ComponentType.SENTENCE_DELIMITER) &&
                    !component.getType().equals(ComponentType.WORD_DELIMITER)) {
                ++size;
            }
        }
        return size;
    }

    public TextComposite() {

    }

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void setType(ComponentType type) {
        componentType = type;
    }


    @Override
    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Component component : components) {
            result.append(component);
        }
        return result.toString();
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException();
    }
}