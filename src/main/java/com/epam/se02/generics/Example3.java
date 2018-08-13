package com.epam.se02.generics;

public class Example3 {

    public static void main(String[] args) {
        Optional<Integer> optionalInteger = new Optional<>(123);
//        optionalInteger.setValue("123");

        Optional rawOptional = optionalInteger;
        rawOptional.setValue("123");

        Integer value = optionalInteger.getValue();
        System.out.println(value);

    }
}
