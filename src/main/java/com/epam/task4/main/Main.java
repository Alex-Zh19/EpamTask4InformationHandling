package com.epam.task4.main;

import com.epam.task4.parser.Parser;
import com.epam.task4.parser.impl.ParseTextToParagraph;
import com.epam.task4.reader.CustomReader;
import com.epam.task4.reader.impl.TextReader;
import com.epam.task4.composite.Component;
import com.epam.task4.composite.impl.TextComposite;
import com.epam.task4.exception.InformationHandlingException;

import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
       String PATH_TO_FILE = "data/text.txt";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        CustomReader reader = new TextReader();
        Component baseComposite=new TextComposite();
        baseComposite.setType("base");
        /*String exp="sgnwegojnweog. wgweglnwegl. woejnoenwpgn.";
        String [] strings=exp.split("[.]");
        int lengthToFindDelimiter=0;
        String[]delimiters=new String[strings.length];
        int h=0;
        for(String str: strings){
            lengthToFindDelimiter+=str.length();
            Character c=exp.charAt(lengthToFindDelimiter);
            delimiters[h]=c.toString();
            so(str,delimiters[h]);
            lengthToFindDelimiter++;
            h++;
        }*/


       try {
            String r = reader.read(new File(pathToFileUrl.getFile()).getAbsolutePath());
            Parser parser=new ParseTextToParagraph();
            parser.parse(r,baseComposite);
            baseComposite.operation();
        } catch (InformationHandlingException e) {}




    }
    private static void so(String str,String delimiter){

        System.out.println(str.trim()+delimiter);
    }
}
