package com.epam.task4.validator;

public class ExpressionValidator {


    public static boolean validate(String string) {
        String str=string.trim();
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
       return false;
    }

    public static Integer countExpression(String str){
        int result=0;
        System.out.print("( "+str+" )");
        return result;
    }
}