package com.epam.task4.main;

import com.epam.task4.chain.parser.Parser;
import com.epam.task4.chain.parser.impl.ParseTextToParagraph;
import com.epam.task4.chain.reader.CustomReader;
import com.epam.task4.chain.reader.impl.TextReader;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.Composite;
import com.epam.task4.exception.InformationHandlingException;

import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String PATH_TO_FILE = "data/text.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader = new TextReader();
        Component baseComposite=new Composite();
        try {
            String r = reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
            Parser parser=new ParseTextToParagraph();
            parser.parse(r,baseComposite);
            baseComposite.operation();
        } catch (InformationHandlingException e) {

        }


    }
}
