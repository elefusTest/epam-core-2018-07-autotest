package com.epam.s06.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(0, "a", "a"),
                new Student(1, "b", "a"),
                new Student(4, "e", "a"),
                new Student(3, "c", "a"),
                new Student(5, "f", "a"),
                new Student(2, "d", "a")
        );

        // id > 3
        // sorted by name
        // transform to full-name
        // String contains all full-names devided by ','
        String result = students.stream()
                                .filter(student -> student.getId() > 3)
                                .sorted(Comparator.comparing(Student::getName))
                                .map(student -> student.getSurname() + " " + student.getName())
                                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);
    }
}
