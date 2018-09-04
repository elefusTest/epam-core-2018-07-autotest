package com.epam.s06.streams;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Group {

    @Getter
    List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }
}
