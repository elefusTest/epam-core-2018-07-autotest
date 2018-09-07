package com.epam.se09.stax;

public class StAXStudentMain {

    public static void main(String[] args) throws Exception {
        new StAXStudentParser().parse(StAXStudentMain.class.getResourceAsStream("./../dtd/students.xml"));
    }
}

