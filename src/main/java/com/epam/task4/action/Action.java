package com.epam.task4.action;

import com.epam.task4.composite.Component;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.impl.SymbolLeaf;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.validator.ExpressionValidator;

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

    public List<Component> findSentencesWithLongestWord(Component component) throws InformationHandlingException {//fix
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        int maxLength = 0;
        final List<Component> resultSentences=new ArrayList<>();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                if (sentence.getType() != ComponentType.SPACE_TAB_DELIMITER) {
                    List<Component> words = sentence.getComponents();
                    for (Component word : words) {
                        if (!isDelimiterLeaf(word)) {
                            if (word.getSizeOfComponents() > maxLength) {
                                maxLength = word.getSizeOfComponents();
                            }
                        }
                    }
                }
            }
        }
        final int max=maxLength;
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                if(sentence.getType()!=ComponentType.SPACE_TAB_DELIMITER) {
                    sentence.getComponents().stream().filter(word -> !isDelimiterLeaf(word)).
                            map(word->(word.getSizeOfComponents()==max)?resultSentences.add(sentence):false);
                }
            }
        }

        return resultSentences;
    }

    public void deleteSentencesLessThan(Component component, int countOfWords) throws InformationHandlingException {//do not work
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();

        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            paragraph.setComponents(sentences.stream().filter(sentence ->!isDelimiterLeaf(sentence)).
                    filter(sentence->sentence.getSizeOfComponents() >= countOfWords+2).//one point for last delimiter and one
                    collect(Collectors.toList()));//for space
        }
        component.setComponents(paragraphs);
    }


    private void checkComponentIsText(Component component) throws InformationHandlingException {
        if (!component.getClass().equals(TextComposite.class) || !component.getType().equals(ComponentType.TEXT)) {
            throw new InformationHandlingException("illegal component type");
        }
    }

    private boolean isDelimiterLeaf(Component component){
       return component.getType()==ComponentType.SPACE_TAB_DELIMITER||component.getType()==ComponentType.SENTENCE_DELIMITER;
    }
}
