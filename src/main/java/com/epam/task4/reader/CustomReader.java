package com.epam.task4.reader;

import com.epam.task4.exception.InformationHandlingException;

public interface CustomReader {
    String read(String fileName) throws InformationHandlingException;
}
