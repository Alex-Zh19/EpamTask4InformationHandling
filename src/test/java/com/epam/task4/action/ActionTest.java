package com.epam.task4.action;

import com.epam.task4.composite.Component;
import com.epam.task4.composite.ComponentType;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;
import com.epam.task4.parser.Parser;
import com.epam.task4.parser.impl.ParseTextToParagraph;
import com.epam.task4.reader.CustomReader;
import com.epam.task4.reader.impl.TextReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.*;

public class ActionTest {
    private Component text;

    @BeforeTest
    public void initialization() throws InformationHandlingException {
        String PATH_TO_FILE = "dataTest/textTest.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader = new TextReader();
        Component baseComposite = new TextComposite();
        baseComposite.setType(ComponentType.BASE);
        String r = reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
        Parser parser = new ParseTextToParagraph();
        parser.parse(r, baseComposite);
        List<Component> textComposite = baseComposite.getComponents();
        text = textComposite.get(0);
    }
    
    @Test
    public void testSortByCountOfSentences() throws InformationHandlingException {
        Action action = new Action();
        String textActual = action.sortByCountOfSentences(text).toString();
        String textExpected = "\n\t It has survived - not only (five) centuries, but also the leap into 52 electronic " +
                "typesetting, remaining 0 essentially 9 unchanged. It was popularised in the " +
                "5 with the release of Letraset sheets containing " +
                "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus " +
                "PageMaker including versions of Lorem Ipsum!\n" +
                "\t It is a long established fact that a reader will be distracted by the readable content of a " +
                "page when looking at its layout. The point of using 78 " +
                "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content " +
                "here), content here', making it look like readable English?\n" +
                "\t It is a 1202 established fact that a reader will be of a page " +
                "when looking at its layout.\n" +
                "\t Bye.";
        assertEquals(textActual, textExpected);
    }

    @Test
    public void testFindSentencesWithLongestWord() throws InformationHandlingException {
        Action action = new Action();
        List<Component> sentences = action.findSentencesWithLongestWord(text);
        String sentenceExpected = " The point of using 78 Ipsum is that it has a more-or-less normal " +
                "distribution of letters, as opposed to using (Content here), content here', " +
                "making it look like readable English?";
        String sentenceActual = sentences.get(0).toString();
        assertEquals(sentenceActual, sentenceExpected);
    }

    @Test
    public void testDeleteSentencesLessThan() throws InformationHandlingException {
        Action action = new Action();
        String textActual = action.deleteSentencesLessThan(text, 29).toString();
        String textExpected = " It was popularised in the " +
                "5 with the release of Letraset sheets containing " +//at first sentence there is 31word
                "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus " +
                "PageMaker including versions of Lorem Ipsum! The point of using 78 Ipsum is that it has a more-or-less normal " +
                "distribution of letters, as opposed to using (Content here), content here'," +//at the second 30
                " making it look like readable English?";
        assertEquals(textActual, textExpected);
    }

    @Test
    public void testFindCountIdenticalWords() throws InformationHandlingException {
        Action action = new Action();
        int countActual = action.findCountIdenticalWords(text);
        int countExpected = 12;
        assertEquals(countActual,countExpected);
    }

    @Test
    public void testCountVowels() throws InformationHandlingException {
        Action action = new Action();
        int countVowelsActual = action.countVowels(text);
        int countVowelsExpected=235;
        assertEquals(countVowelsActual,countVowelsExpected);
    }

    @Test
    public void testCountConsonants() throws InformationHandlingException {
        Action action = new Action();
        int countConsonantsActual = action.countConsonants(text);
        int countConsonantsExpected=351;
        assertEquals(countConsonantsActual,countConsonantsExpected);
    }


}