package com.epam.se02.generics;

import java.util.Arrays;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
//        Message<Integer, String> message = new Message<Double, String>(20d, "qwe");
//        message.getId();
//        message.getName();

        String[] string = new String[]{"a", "b", "c"};
        Object[] objects = string;

//        List<String> listStrings = Arrays.asList("a", "b", "c");
//        List<Object> objectsList = listStrings;

    }
}

class Message<T1, T2> {

    T1 id;
    T2 name;

    public Message(T1 id, T2 name) {
        this.id = id;
        this.name = name;
    }

    public T1 getId() {
        return id;
    }

    public T2 getName() {
        return name;
    }
}
