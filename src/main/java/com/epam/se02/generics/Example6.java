package com.epam.se02.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example6 {

    public static void main(String[] args) {
//        Person[] people = new Person[3];
//        people[0] = new Student(55, "a", "b");
//        people[1] = new Student(60, "a", "b");
//        people[2] = new Student(70, "a", "b");

        Comparator<Person> comparator1 = new PersonObjectByNameCompartor();
        Comparator<PhysicalObject> comparator2 = new PhysicalObjectByWeightCompartor();
        Comparator<Object> comparator3 = new ObjectByHashcodeComparator();

        List<Student> people = new ArrayList<>();
        people.add(new Student(55, "a", "b"));
        people.add(new Student(60, "a", "b"));
        people.add(new Student(70, "a", "b"));

        sort(people, comparator2);
    }

    public static void sort(List<? extends Person> people, Comparator<? super Person> comparator) {
        people.sort(comparator);
    }
}

class PhysicalObjectByWeightCompartor implements Comparator<PhysicalObject> {

    @Override
    public int compare(PhysicalObject o1, PhysicalObject o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

class PersonObjectByNameCompartor implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ObjectByHashcodeComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

abstract class PhysicalObject {

    private int weight;

    public PhysicalObject(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}


class Person extends PhysicalObject {

    private final String name;
    private final String surName;

    public Person(int weight, String name, String surName) {
        super(weight);
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}

class Student extends Person {

    private int averageMark;

    public Student(int weight, String name, String surName) {
        super(weight, name, surName);
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }
}