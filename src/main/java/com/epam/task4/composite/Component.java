package com.epam.task4.composite;

public interface Component {
    void operation();

    boolean add(Component component);

    boolean remove(Component component);

    String getType();

    void setType(String type);
}
