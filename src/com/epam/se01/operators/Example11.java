package com.epam.se01.operators;

public class Example11 {

    public static void main(String[] args) {
        int value = 10;
        Integer wrapper = value;
        String stringInteger = wrapper.toString();
        String stringInteger2 = String.valueOf(value);

        String stringInteger3 = "123";
        Integer integerValue = Integer.valueOf(stringInteger3);
        int intValue = Integer.parseInt(stringInteger3);


        String stringInteger4 = 10 + "";
        System.out.println(stringInteger4);


    }
}
