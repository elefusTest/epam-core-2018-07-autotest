package com.epam.se06.streams;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

    public static void main(String[] args) {
        String[] strings = Stream.of(5, 3, 1, 2, 3, 4, 5, 45, 50, 60, 70)
                                 .distinct()
                                 .sorted(Collections.reverseOrder())
                                 .skip(2)
                                 .limit(5)
                                 .filter(x -> x > 3)
                                 .map(String::valueOf)
                                 .takeWhile(str -> str.length() > 1)
                                 .peek(System.out::println)
                                 .toArray(String[]::new);

//        String[] strings = ((String[]) objects);
        System.out.println(strings[0].getClass());
        System.out.println(strings[1].getClass());
//        System.out.println(Arrays.toString(objects));
//                                 .max(Comparator.comparingInt(String::length)));


        Stream<String> stream = Stream.of("a", "b", "c", "d")
                                      .filter(str -> !"a".equals(str));

        List<String> list = stream.collect(Collectors.toList());

        try {
            Set<String> set = stream.collect(Collectors.toSet());
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }

        TreeSet<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));


    }
}
