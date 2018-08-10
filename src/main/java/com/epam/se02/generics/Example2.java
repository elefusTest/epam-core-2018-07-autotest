package com.epam.se02.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        Optional<Integer> optional = new Optional<>();
//        int value = optional.getValue();
//        System.out.println(value);

        // raw collections
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List rawList = list;
        rawList.add(123);

        String s1 = list.get(0);
        String s2 = list.get(1);
        String s3 = list.get(2);
        String s4 = list.get(3);

        System.out.println(s4);
    }
}
