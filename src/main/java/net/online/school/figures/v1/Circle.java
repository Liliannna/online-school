package net.online.school.figures.v1;

import java.util.Objects;

public class Circle {

    private Point2D center;
    private int radius;

    //Создает Circle по координатам центра и значению радиуса.
    public Circle(Point2D center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    //Создает Circle по координатам центра и значению радиуса.
    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point2D(xCenter, yCenter), radius);
    }

    //Создает Circle с центром в точке (0,0) указанного радиуса.
    public Circle(int radius) {
        this(0, 0, radius);
    }

    // Создает Circle с центром в точке (0,0) с радиусом 1.
    public Circle() {
        this(0, 0, 1);
    }

    //Возвращает центр Circle.
    public Point2D getCenter() {
        return center;
    }

    //Возвращает радиус Circle.
    public int getRadius() {
        return radius;
    }

    //Устанавливает центр Circle.
    public void setCenter(Point2D center) {
        this.center = center;
    }

    //Устанавливает радиус Circle.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    //Передвигает Circle на (dx, dy).
    public void moveRel(int dx, int dy) {
    getCenter().moveRel(dx, dy);
    }

    // Увеличивает радиус Circle в n раз, не изменяя центра.
    public void enlarge(int n) {
        setRadius(getRadius() * n);
    }

    //Возвращает площадь круга.
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //Возвращает периметр окружности (длину окружности).
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //Определяет, лежит ли точка (x, y) внутри Circle.
    //Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return (center.getX() - x) * (center.getX() - x) + (center.getY() - y) * (center.getY() - y) <= radius * radius;

    }

    //Определяет, лежит ли точка point внутри Circle.
    //Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (radius != circle.radius) return false;
        return Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        int result = center != null ? center.hashCode() : 0;
        result = 31 * result + radius;
        return result;
    }
}
