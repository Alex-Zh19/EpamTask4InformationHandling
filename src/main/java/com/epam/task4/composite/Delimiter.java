package com.epam.task4.composite;

public enum Delimiter {
    COMMA(","),
    DOT("."),
    EXCLAMATION("!"),
    QUESTION("?"),
    DASH("-"),
    SPACE(" "),
    TAB("\n\t");


    private String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Delimiter getDelimiter(String value) {
        if (value.equals(COMMA.value)) {
            return COMMA;
        } else if (value.equals(DOT.value)) {
            return DOT;
        } else if (value.equals(EXCLAMATION.value)) {
            return EXCLAMATION;
        } else if (value.equals(QUESTION.value)) {
            return QUESTION;
        } else if(value.equals(DASH.value)) {
            return DASH;
        }else if(value.equals(SPACE.value)){
            return SPACE;
        }else{
            return TAB;
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
