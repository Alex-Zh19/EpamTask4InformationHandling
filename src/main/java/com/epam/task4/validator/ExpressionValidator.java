package com.epam.task4.validator;

import com.epam.task4.composite.Delimiter;

public class ExpressionValidator {


    public static boolean validate(String string) {
        String str = string.trim();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSentenceDelimiter(String symbol){
        return symbol.equals(Delimiter.DOT.getValue()) || symbol.equals(Delimiter.EXCLAMATION.getValue()) ||
                symbol.equals(Delimiter.QUESTION.getValue());
    }

    public static boolean isWordDelimiter(String symbol){
        return symbol.equals(Delimiter.COMMA.getValue()) || symbol.equals(Delimiter.DASH.getValue());
    }

}
