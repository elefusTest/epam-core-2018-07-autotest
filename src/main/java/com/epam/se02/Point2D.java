package com.epam.se02;

public class Point2D {

    private int x = 0;
    private int y = 0;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(int position) {
        this(position, position);
    }

    public Point2D() {
        this(0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void method(Point2D point) {
        Point2D point2D = new Point2D();
        System.out.println(point2D.x);
        System.out.println(point2D.y);
        System.out.println(point.x);
        System.out.println(point.y);
        System.out.println("Static method in abstract class");
    }

}

class Launcher2 {

    public static void main(String[] args) {
//        Point2D point = new Point2D();
//        System.out.println(point.getX());
//        System.out.println(point.getY());
//
//        System.out.println(new StringBuilder());
    }
}