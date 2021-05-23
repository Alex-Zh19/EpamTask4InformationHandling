package com.epam.task4.action;

import com.epam.task4.composite.Component;
import com.epam.task4.exception.InformationHandlingException;

import java.util.List;

public interface CompositeAction {
    Component sortByCountOfSentences(Component component) throws InformationHandlingException;

    List<Component> findSentencesWithLongestWord(Component component) throws InformationHandlingException;

    Component deleteSentencesLessThan(Component component, int countOfWords) throws InformationHandlingException;

    int findCountIdenticalWords(Component component) throws InformationHandlingException;

    int countVowels(Component component) throws InformationHandlingException;

    int countConsonants(Component component) throws InformationHandlingException;
}
