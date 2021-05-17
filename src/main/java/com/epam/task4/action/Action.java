package com.epam.task4.action;

import com.epam.task4.composite.Component;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Action {
    public void sortByCountOfSentences(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();

        component.setComponents(paragraphs.stream().sorted((o1, o2) -> o2.getSizeOfComponents() - o1.getSizeOfComponents()).
                collect(Collectors.toList()));

    }

    public List<Component> findSentencesWithLongestWord(Component component) throws InformationHandlingException {//do not work
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        int maxLength = 0;
        List<Component> resultSentences = new ArrayList<>();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();
                for (Component word : words) {
                    if (word.getSizeOfComponents() > maxLength) {
                        maxLength = word.getSizeOfComponents();
                    }
                }
            }
        }
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                List<Component> words = sentence.getComponents();
                for (Component word : words) {
                    if (word.getSizeOfComponents() == maxLength) {
                        resultSentences.add(sentence);
                    }
                }
            }
        }

        return resultSentences;
    }

    public void deleteSentencesLessThan(Component component, int countOfWords) throws InformationHandlingException {//do not work
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();

        for (Component paragraph : paragraphs) {
            List<Component>sentences=paragraph.getComponents();
            paragraph.setComponents(sentences.stream().filter(sentence -> sentence.getSizeOfComponents() >= countOfWords).
                    collect(Collectors.toList()));
        }
       component.setComponents(paragraphs);
    }


    private void checkComponentIsText(Component component) throws InformationHandlingException {
        if (!component.getClass().equals(TextComposite.class) || !component.getType().equals(ComponentType.TEXT)) {
            throw new InformationHandlingException("illegal component type");
        }
    }
}
