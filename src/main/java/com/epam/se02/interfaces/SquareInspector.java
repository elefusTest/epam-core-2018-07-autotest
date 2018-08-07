package com.epam.se02.interfaces;

public class SquareInspector {

    public static void main(String[] args) {
        Square box = new Quadrate(4);
        Square rectangle = new Rectangle(2, 3);
        Square circle = new Circle(3);
        Square someObject = () -> 0;

        System.out.println("Box: " + box.square());
        System.out.println("Rect.: " + rectangle.square());
        System.out.println("Circle: " + circle.square());

    }
}

