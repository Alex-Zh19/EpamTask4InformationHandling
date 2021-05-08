package com.epam.task4.composite;

public enum Delimiter {
    COMMA(","),
    DOT("."),
    EXCLAMATION("!"),
    QUESTION("?"),
    DASH("-");

    private String value;

    Delimiter(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public static Delimiter getDelimiter(String value){
        if(value.equals(COMMA.value)){
            return COMMA;
        }else if(value.equals(DOT.value)){
            return DOT;
        }else if(value.equals(EXCLAMATION.value)){
            return EXCLAMATION;
        }else if(value.equals(QUESTION.value)){
            return QUESTION;
        }else {
            return DASH;
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
