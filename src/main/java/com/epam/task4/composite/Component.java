package com.epam.task4.composite;

public interface Component {
    void operation();

    boolean add(Component component);

    boolean remove(Component component);

    ComponentType getType();

    void setType(ComponentType type);
}
