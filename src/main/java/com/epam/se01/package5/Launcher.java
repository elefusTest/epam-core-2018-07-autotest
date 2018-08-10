package com.epam.se01.package5;

public class Launcher {

    public static void main(String[] args) {
        ColoredPoint[] coloredPoints = new ColoredPoint[10];
        Point[] points = coloredPoints;

        System.out.println(coloredPoints[0] == null);

//        points[0] = new Point();
//        System.out.println(coloredPoints[0].getColor());
        System.out.println(coloredPoints[11]);
        System.out.println(coloredPoints[11]);

    }
}
