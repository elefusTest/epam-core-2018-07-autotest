package com.epam.se06.streams;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Example2 {

    public static void main(String[] args) {
        Example2.getById(1)
                .map(student -> student.getSurname() + " " + student.getName())
                .ifPresent(System.out::println);

//        Optional<Student> or = result.or(() -> Optional.of(new Student(0, "default", "default")));
//        Student student = result.orElse(new Student(0, "default", "default"));
//        result.orElseThrow(() -> new RuntimeException());


//        if (result.isPresent()) {
//            Student student = result.get();
//            System.out.println(student.getSurname() + " " + student.getName());
//        }
//
//
//        if (result != null) {
//            System.out.println(result.getSurname() + " " + result.getName());
//        }
    }

    public static Optional<Student> getById(long id) {
        // TODO connection to DB
        if (ThreadLocalRandom.current().nextBoolean()) {
            return Optional.of(new Student(id, "Ivan", "Ivanov"));
        } else {
            return Optional.empty();
        }

    }
}
