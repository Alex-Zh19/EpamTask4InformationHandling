package com.epam.task4.composite;

import java.util.List;

public interface Component {

    boolean add(Component component);

    boolean remove(Component component);

    ComponentType getType();

    void setType(ComponentType type);

    List<Component>getComponents();

    int getSizeOfComponents();

    void setComponents(List<Component> components);

    String getSymbol();
}
