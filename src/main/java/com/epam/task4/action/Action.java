package com.epam.task4.action;

import com.epam.task4.composite.Component;

import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.impl.SymbolLeaf;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;

import java.util.*;
import java.util.stream.Collectors;


public class Action {
    private static final String REG_FOR_VOWELS = "[AaEeIiOoUuYy]";
    private static final String REG_FOR_CONSONANTS = "[[^AEIOUaeiou]&&a-zA-Z]";

    public Component sortByCountOfSentences(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        Component newText=new TextComposite();
        List<Component> paragraphs = component.getComponents();
        newText.setComponents(paragraphs.stream().sorted((o1, o2) -> o2.getSizeOfComponents() - o1.getSizeOfComponents()).
                collect(Collectors.toList()));
        return newText;

    }

    public List<Component> findSentencesWithLongestWord(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        int maxLength = 0;
        final List<Component> resultSentences = new ArrayList<>();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                if (!isDelimiterLeaf(sentence)) {
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
        final int max = maxLength;
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                if (!isDelimiterLeaf(sentence)) {
                    sentence.getComponents().stream().filter(word -> !isDelimiterLeaf(word)).
                            filter(word -> word.getSizeOfComponents() == max).
                            map(sentence1 -> resultSentences.add(sentence)).collect(Collectors.toList());
                }
            }
        }
        return resultSentences;
    }

    public Component deleteSentencesLessThan(Component component, int countOfWords) throws InformationHandlingException {
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        Component newText = new TextComposite();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            paragraph.setComponents(sentences.stream().filter(sentence -> !isDelimiterLeaf(sentence)).
                    filter(sentence -> sentence.getSizeOfComponents() >= countOfWords).
                    collect(Collectors.toList()));
        }
        newText.setComponents(paragraphs);
        return newText;
    }


    public int findCountIdenticalWords(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        Map<String, Integer> wordCounter = new HashMap<>();
        List<Component> paragraphs = component.getComponents();
        for (Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getComponents();
            for (Component sentence : sentences) {
                if (!isDelimiterLeaf(sentence)) {
                    List<Component> words = sentence.getComponents();
                    for (Component word : words) {
                        if (!isDelimiterLeaf(word)) {
                            StringBuilder oneWord = new StringBuilder();
                            List<Component> symbols = word.getComponents();
                            for (Component symbol : symbols) {
                                if (!isDelimiterLeaf(symbol)) {
                                    SymbolLeaf current = (SymbolLeaf) symbol;
                                    oneWord.append(current.getSymbol());
                                    wordCounter.merge(oneWord.toString(), 1, (prev, one) -> prev + 1);
                                }
                            }
                        }

                    }
                }
            }
        }
        return Collections.max(wordCounter.values());
    }

    public int countVowels(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        return (int) countSymbols(paragraphs, REG_FOR_VOWELS);
    }

    public int countConsonants(Component component) throws InformationHandlingException {
        checkComponentIsText(component);
        List<Component> paragraphs = component.getComponents();
        return (int) countSymbols(paragraphs, REG_FOR_CONSONANTS);
    }

    private long countSymbols(List<Component> paragraphs, String reg) {
        return paragraphs.stream().filter(paragraph -> !isDelimiterLeaf(paragraph)).
                flatMap(paragraph -> paragraph.getComponents().stream()).filter(sentence -> !isDelimiterLeaf(sentence)).
                flatMap(sentence -> sentence.getComponents().stream()).filter(word -> !isDelimiterLeaf(word)).
                flatMap(word -> word.getComponents().stream()).filter(symbol -> symbol.toString().matches(reg))
                .count();
    }

    private void checkComponentIsText(Component component) throws InformationHandlingException {
        if (!component.getClass().equals(TextComposite.class) || !component.getType().equals(ComponentType.TEXT)) {
            throw new InformationHandlingException("illegal component type");
        }
    }

    private boolean isDelimiterLeaf(Component component) {
        return component.getType().equals(ComponentType.SPACE_TAB_DELIMITER) ||
                component.getType().equals(ComponentType.SENTENCE_DELIMITER) ||
                component.getType().equals(ComponentType.WORD_DELIMITER);
    }
}
