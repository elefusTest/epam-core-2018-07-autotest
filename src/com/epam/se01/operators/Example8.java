package com.epam.se01.operators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Example8 {

    public static void main(String[] args) {
//        if (true) {
//            System.out.println("13");
//        }
////        } else {
////
////        }
//
//        for (int i = 0; i < args.length; ++i) {
//            System.out.println(args[i]);
//        }


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer value = iter.next();
            System.out.println(value);
        }

        for (Integer value : list) {
            System.out.println(value);
        }

        list.forEach(System.out::println);

    }
}
