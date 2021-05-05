package com.epam.task4.composite.impl;

import com.epam.task4.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String componentType;

    public Composite(){

    }

    public Composite(String componentType){
        this.componentType=componentType;
    }



    @Override
    public void operation() {
        components.forEach(Component::operation);
    }

    @Override
    public boolean add(Component component) {
        return component.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return component.remove(component);
    }

    @Override
    public String getType() {
        return componentType;
    }
}
