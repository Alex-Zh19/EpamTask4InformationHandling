package com.epam.task4.main;

import com.epam.task4.chain.reader.CustomReader;
import com.epam.task4.chain.reader.impl.TextReader;
import com.epam.task4.exception.InformationHandlingException;

import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String PATH_TO_FILE="data/text.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader=new TextReader();
        try {
           String r= reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
            System.out.println(r);
        }catch (InformationHandlingException e){

        }

    }
}
