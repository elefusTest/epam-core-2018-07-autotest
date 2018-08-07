package com.epam.se02.annotations;

@Anno1(value = "Мама мыла раму!")
public final class MyClass {
    public static void main(String... __) {
        Anno1 annotation = MyClass.class.getAnnotation(Anno1.class);
        System.out.println(annotation.value()); // "Мама мыла раму!"
    }
}
