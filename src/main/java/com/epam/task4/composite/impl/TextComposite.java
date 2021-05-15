package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components = new ArrayList<>();
    private String componentType;

    public TextComposite() {

    }

    public TextComposite(String componentType) {
        this.componentType = componentType;
    }

    @Override
    public void setType(String type) {
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
    public String getType() {
        return componentType;
    }
}
