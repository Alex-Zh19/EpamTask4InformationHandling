package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components = new ArrayList<>();
    private ComponentType componentType;

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
    public void operation() {
        for (Component component : components) {
            if (component.getType().equals("paragraph")) {
                System.out.println();
            }
            component.operation();
        }
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
}
