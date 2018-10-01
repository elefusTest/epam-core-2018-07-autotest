package com.epam.se02.strings;

import java.util.*;
import java.util.function.Consumer;

public class Example {

    public static void main(String[] args) {
//        method();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        for (Integer value : integers) {
            if (value > 1) {
                integers.remove(value);
            }
        }
    }

    private static void method() {
        String a1 = "a";
        String a2 = new String("a").intern();
        System.out.println(a1 == a2);


        List<Integer> list = Arrays.asList(1, 2, 3);
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        for (Integer value : list) {
            System.out.println(value);
        }

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });

        list.forEach((Integer value) -> {
            System.out.println(value);
        });

        list.forEach(value -> {
            System.out.println(value);
        });

        list.forEach(value -> System.out.println(value));

        list.forEach(System.out::println);


        Map<Integer, String> map = new HashMap<>();
        map.put(10, "a");
        map.put(15, "b");
        String c = map.put(15, "c");
        map.put(17, "d");
        map.get(15);

        // | 0 | 1 | 2 | 3 |
        //       |
        //    <10, a>
        //       |
        //    <15, c>
        //       |
        //    <17, d>
    }
}
