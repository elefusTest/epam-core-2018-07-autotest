package com.epam.se02.generics;

import java.util.List;

public class Mark<T extends Number> {

    private final T mark;

    public Mark(T value) {
        mark = value;
    }

    public T getMark() {
        return mark;
    }

    public int roundMark() {
        return Math.round(mark.floatValue());
    }

    public boolean same(Mark<T> ob) {
        return mark.equals(ob.mark);
    }

    /* вместо */
    public boolean sameAny(Mark<?> ob) {
        return roundMark() == ob.roundMark();
    }
}

class Launcher2 {

    public static void main(String[] args) {
//        Mark<Long> longMark = new Mark<>(1L);
//        Mark<Integer> integerMark = new Mark<>(1);
//        longMark.sameAny(integerMark);


        Mark<Double> md = new Mark<>(71.4D);//71.5d
        System.out.println(md.sameAny(md));

        Mark<Integer> mi = new Mark<>(71);
        System.out.println(md.sameAny(mi));

        System.out.println(md.roundMark());
    }
}

