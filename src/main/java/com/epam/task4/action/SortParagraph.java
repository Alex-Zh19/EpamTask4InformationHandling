package com.epam.task4.action;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class SortParagraph {
    List<Component>paragraphs=new ArrayList<>();

    public void sortByCountOfSentences(List<Component> text){
        int counter=0;
        for(Component component:text){
            if(component.getType()==ComponentType.DELIMITER){

            }
            if(component.getType()== ComponentType.PARAGRAPH){

            }
        }
    }
}
