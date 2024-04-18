package net.online.school.figures.v3;

import net.online.school.colors.Color;
import net.online.school.colors.ColorException;

public class Circle extends Figure {
    private Point2D center;
    private int radius;

    public Circle(Point2D center, int radius, Color color) throws ColorException {
        this.center = center;
        this.radius = radius;
        setColor(color);
    }

    public Circle(Point2D center, int radius, String color) throws ColorException {
        this.center = center;
        this.radius = radius;
        setColor(color);
    }

    public Circle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int radius, Color color) throws ColorException {
        this(0, 0, radius, color);
    }

    public Circle(int radius, String color) throws ColorException {
        this(0, 0, radius, color);
    }

    public Circle(Color color) throws ColorException {
        this(0, 0, 1, color);
    }

    public Circle(String color) throws ColorException {
        this(0, 0, 1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void moveRel(int dx, int dy) {
        getCenter().moveRel(dx, dy);
    }

    public void enlarge(int n) {
        setRadius(radius * n);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        return (center.getX() - x) * (center.getX() - x) + (center.getY() - y) * (center.getY() - y) <= radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        if (radius != circle.radius) return false;
        return center != null ? center.equals(circle.center) : circle.center == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + radius;
        return result;
    }
}