package net.online.school.figures.v3;

import net.online.school.colors.Color;
import net.online.school.colors.ColorException;

public class CircleFactory {

    private static int circleCount = 0;

    public static Circle createCircle(Point2D center, int radius, Color color) throws ColorException {
        circleCount++;
        return new Circle(center, radius, color);
    }

    public static Circle createCircle(Point2D center, int radius, String color) throws ColorException {
        circleCount++;
        return new Circle(center, radius, color);
    }

    public static int getCircleCount() {
        return circleCount;
    }

    public static void reset() {
        circleCount = 0;
    }
}
