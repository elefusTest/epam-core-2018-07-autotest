package com.epam.se09.gson;

import com.epam.se09.dom.Address;
import com.epam.se09.dom.Student;
import com.google.gson.Gson;

import java.lang.reflect.Field;

public class Launcher {

    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student("Ivan007", "Ivan", "ETU", 777, new Address("ru", "spb", "qqq"));

        Class<? extends Student> clazz = student.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.get(student));
        }

        Gson gson = new Gson();
        String jsonRepresentation = gson.toJson(student);

        System.out.println(jsonRepresentation);

        Student student1 = gson.fromJson(jsonRepresentation, Student.class);

        System.out.println(student == student1);
        System.out.println(student.equals(student1));
        System.out.println(student1);
    }
}
