package net.online.school.figures.v2;

public class Circle extends Figure {
    private Point2D center;
    private int radius;

    public Circle(Point2D center, int radius, int color) {
        this.center = center;
        this.radius = radius;
        super.setColor(color);
    }

    public Circle(int xCenter, int yCenter, int radius, int color) {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int radius, int color) {
        this(0, 0, radius, color);
    }

    public Circle(int color) {
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