package com.epam.se01.operators;

public class Example10 {

    public static void main(String[] args) {
        Example10[] arr = new Example10[]{
            new Example10(),
            new Example10(),
            new Example10()
        };
        arr[0].sayHello();
        arr[1].sayHello();


        doLogic(new BaseCourse());
        doLogic(new OptionalCourse());
        doLogic(new FreeCourse());

        Example10 ref = new Example10();
        ref.sayHello();
    }

    public static void doLogic(Course c) {
        if (c instanceof BaseCourse) {
            System.out.println("BaseCourse");
        } else if (c instanceof OptionalCourse) {
            System.out.println("OptionalCourse");
        } else {
            System.out.println("Что-то другое.");
        }
    }

    public void sayHello() {
        System.out.println("Hello");
    }

}

class Course {}
class OptionalCourse extends Course {}
class BaseCourse extends Course {}
class FreeCourse extends BaseCourse {}


