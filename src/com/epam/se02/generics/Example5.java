package com.epam.se02.generics;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayList;
import java.util.List;

public class Example5 {

    public static void main(String[] args) {
        // ? extends T
        // ? super T


        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1L);
        numbers.add(1f);

        Integer number = ((Integer) numbers.get(0));
        System.out.println(number);

        // PECS
        // Producer
        // Extends
        List<? extends Number> numbers1 = new ArrayList<Long>();
//        numbers1.add(1);
//        numbers1.add(1L);
//
//        Number value = 50;
//        numbers1.add(value);
//        numbers1.add(null);
//
//        Number number1 = numbers1.get(0);


        // Consumer
        // Super
        List<? super Number> numbers2 = new ArrayList<Object>();
//        numbers2.add("123");
        numbers2.add(1);
        numbers2.add(1L);
        numbers2.add(1f);

        Object object = numbers2.get(0);

    }
}
