package com.epam.se02.compare;

public class Person implements Comparable<Person> {

    public final String name;
    public final String surName;
    public final String patronymic;
    public int age;

    public Person(String surName, String name, String patronymic, int age) {
        this.name = name;
        this.surName = surName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFullName() {
        return surName + name + patronymic;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }
}
