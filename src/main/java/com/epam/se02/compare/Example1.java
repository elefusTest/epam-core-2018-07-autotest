package com.epam.se02.compare;

import java.util.Arrays;
import java.util.Comparator;

public class Example1 {

    public static void main(String[] args) {
        Person[] people = new Person[] {
            new Person("Иванов", "Иван", "Иванович", 18),
            new Person("Николаев", "Сергей", "Николаевич", 19),
            new Person("Николаев", "Николай", "Николаевич", 20),
            new Person("Николаев", "Николай", "A123", 18),
            new Person("A123", "B", "C", 16),
        };

//        Arrays.sort(people, new PersonByAgeComparator());
        Arrays.sort(people, Comparator.comparingInt(Person::getAge));



        System.out.println(Arrays.toString(people));
    }

}

class PersonByAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person left, Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
